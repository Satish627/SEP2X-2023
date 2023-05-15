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
import javafx.util.converter.NumberStringConverter;

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

    @FXML private TextField employeeName;
    @FXML
    private Button saveBtn;


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        addShiftViewModel = viewModelFactory.getAddShiftViewModel();
        bindValuesToTextField();
    }

    private void bindValuesToTextField() {
        shiftId.textProperty().bindBidirectional(addShiftViewModel.getShiftID(), new NumberStringConverter());
        employeeId.textProperty().bindBidirectional(addShiftViewModel.getEmployeeID(), new NumberStringConverter());
        employeeName.textProperty().bindBidirectional(addShiftViewModel.getEmployeeName());
        startTime.textProperty().bindBidirectional(addShiftViewModel.getStartTime());
        endTime.textProperty().bindBidirectional(addShiftViewModel.getEndTime());
        datePicker.valueProperty().bindBidirectional(addShiftViewModel.getDate());

    }

    public void onDateSelected(ActionEvent actionEvent) {
    }
  /*  @FXML
    public void datePicker(ActionEvent event) {
        LocalDate localDate = datePicker.getValue();
        System.out.println(localDate.toString());
        String pattern = "MMMM, dd,YYYY";
        String datePattern = localDate.format(DateTimeFormatter.ofPattern(pattern));
    }*/

    @FXML
    public void openBackPage(ActionEvent event) {
        viewHandler.openBackPage();
    }


    @FXML
    private void onSaveClicked(ActionEvent event) throws Exception
    {

        try {
            addShiftViewModel.addShift();
            clearTextInputs();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void clearTextInputs()
    {
        shiftId.setText(null);
        employeeId.setText(null);
        employeeName.setText(null);
        datePicker.setValue(null);
        startTime.setText(null);
        endTime.setText(null);
    }
}
