package EmployeeManagementSystem.client.view.AdminViews.UpdateShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateShiftController implements ViewController {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField startTime;
    @FXML
    private TextField endTime;

    private UpdateShiftViewModel viewModel;
    private ViewHandler viewHandler;


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        viewModel = viewModelFactory.getUpdateShiftViewModel();
        this.viewHandler = viewHandler;
        initFields();
    }

    private void initFields() {
        startTime.textProperty().bindBidirectional(viewModel.getStartTime());
        endTime.textProperty().bindBidirectional(viewModel.getEndTime());
        datePicker.valueProperty().bindBidirectional(viewModel.getShiftDate());
    }

    public void openBackPage(ActionEvent actionEvent) {
        try {
            viewHandler.openViewShift();

        } catch (Exception e) {
            AlertBox.showAlert(e.getMessage());
        }
    }


    public void onSaveClicked(ActionEvent actionEvent) {
        try {
            viewModel.updateShift();
            AlertBox.showAlert("Shift has been successfully updated");
        } catch (Exception e) {
            AlertBox.showAlert(e.getMessage());
        }
    }
}
