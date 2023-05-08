package EmployeeManagementSystem.client.view.AdminViews.AddShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private TextField shiftId;
    @FXML
    private TextField startTime;
    @FXML
    private Button saveBtn;

    @FXML
    void datePicker(ActionEvent event) {
        LocalDate localDate = datePicker.getValue();
        String pattern = "MMMM, dd,YYYY";
        String datePattern = localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    @FXML
    void openBackPage(ActionEvent event) {
        viewHandler.openBackPage();
    }


    @FXML
    void onSaveClicked(ActionEvent event) throws Exception
    {

        try {
            addShiftViewModel.addShift();
            clearTextInputs();
        } catch (SQLException | RemoteException e)
        {
            e.printStackTrace();
        }
    }




    private void clearTextInputs()
    {
        shiftId.setText(null);
        employeeId.setText(null);
        datePicker.setValue(null);
        startTime.setText(null);
        endTime.setText(null);


    }

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        addShiftViewModel = viewModelFactory.getAddShiftViewModel();
        bindValuesToTextField();
    }

    private void bindValuesToTextField() {
        shiftId.textProperty().bindBidirectional(addShiftViewModel.getShiftID());
        employeeId.textProperty().bindBidirectional(addShiftViewModel.getEmployeeID());
        startTime.textProperty().bindBidirectional(addShiftViewModel.getStartTime());
        endTime.textProperty().bindBidirectional(addShiftViewModel.getEndTime());
        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            addShiftViewModel.getDate().set(String.valueOf(newValue.getDayOfYear()));
        });
    }
}
