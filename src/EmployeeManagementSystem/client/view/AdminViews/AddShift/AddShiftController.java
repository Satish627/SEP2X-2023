package EmployeeManagementSystem.client.view.AdminViews.AddShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.AlertBox;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;

public class AddShiftController implements ViewController {

    private ViewHandler viewHandler;
    private AddShiftViewModel addShiftViewModel;

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField employeeId;
    @FXML
    private TextField endTime;
    @FXML
    private TextField startTime;


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        addShiftViewModel = viewModelFactory.getAddShiftViewModel();
        bindValuesToTextField();
    }

    private void bindValuesToTextField() {
        String regex = "[0-9]*";

        // Create a TextFormatter with a filter that allows only numbers
        TextFormatter<String> employeeIdTextFormatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches(regex)) {
                return change;
            }
            return null;
        });
        employeeId.setTextFormatter(employeeIdTextFormatter);
        employeeId.textProperty().bindBidirectional(addShiftViewModel.getEmployeeID(), new NumberStringConverter());
        startTime.textProperty().bindBidirectional(addShiftViewModel.getStartTime());
        endTime.textProperty().bindBidirectional(addShiftViewModel.getEndTime());
        datePicker.valueProperty().bindBidirectional(addShiftViewModel.getDate());

    }

    @FXML
    public void openBackPage(ActionEvent event) {
        viewHandler.openViewShift();
    }


    @FXML
    private void onSaveClicked(ActionEvent event) throws Exception
    {
        try {
            addShiftViewModel.addShift();
            AlertBox.showAlert("Shift Has Been Added Successfully");
            clearTextInputs();

        } catch (Exception e)
        {
            AlertBox.showAlert(e.getMessage());
        }
    }


    private void clearTextInputs()
    {
        employeeId.setText(null);
        datePicker.setValue(null);
        startTime.setText(null);
        endTime.setText(null);
    }

}
