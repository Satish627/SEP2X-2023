package EmployeeManagementSystem.client.view.EmployeeViews.EmployeeLeaveRequestPage;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class EmployeeLeaveRequestController implements ViewController{
    private ViewHandler viewHandler;
    private EmployeeLeaveRequestViewModel employeeLeaveRequestViewModel;
    @FXML
    private TextField reason;

    @FXML
    private TextField shiftID;

    public void init(ViewHandler viewHandler,ViewModelFactory viewModelFactory){
        this.viewHandler=viewHandler;
        this.employeeLeaveRequestViewModel=viewModelFactory.getEmployeeLeaveRequestViewModel();
        bindValuesToTextField();
    }

    private void bindValuesToTextField()
    {
        shiftID.textProperty().bindBidirectional(employeeLeaveRequestViewModel.getShiftID(),new NumberStringConverter());
        reason.textProperty().bindBidirectional(employeeLeaveRequestViewModel.getReason());
    }

    @FXML
    public void onEmployeeLeaveRequestBackBtnClicked(ActionEvent event)
    {
        viewHandler.backPage();
    }

    @FXML
    public void onEmployeeLeaveRequestSubmitBtnClicked(ActionEvent event) {
        try {
            employeeLeaveRequestViewModel.requestLeave();
            clearTextInputs();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    public void clearTextInputs(){
        shiftID.setText(null);
        reason.setText(null);
    }

}