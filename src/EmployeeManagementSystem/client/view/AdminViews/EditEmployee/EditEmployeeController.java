package EmployeeManagementSystem.client.view.AdminViews.EditEmployee;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.AdminViews.AddEmployee.AddEmployeeViewModel;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class EditEmployeeController implements ViewController {

    private ViewHandler viewHandler;
    private EditEmployeeViewModel editEmployeeViewModel;
    @FXML
    private TextField firstname,lastName,userId,address,emailId,phoneNum,dateOfBirth;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        editEmployeeViewModel = viewModelFactory.getEditEmployeeViewModel();
      //  bindValuesToTextField();
    }

 /*   private void bindValuesToTextField() {
        firstname.textProperty().bindBidirectional(addEmployeeViewModel.getfirstName());
        lastName.textProperty().bindBidirectional(addEmployeeViewModel.getlastName());
        userId.textProperty().bindBidirectional(addEmployeeViewModel.getUserId(), new NumberStringConverter());
        address.textProperty().bindBidirectional(addEmployeeViewModel.getAddress());
        emailId.textProperty().bindBidirectional(addEmployeeViewModel.getEmailId());
        phoneNum.textProperty().bindBidirectional(addEmployeeViewModel.getPhoneNum(), new NumberStringConverter());
        dateOfBirth.textProperty().bindBidirectional(addEmployeeViewModel.getDateOfBirth());

    }*/

    @FXML
    void backClick(ActionEvent event)
    {
        openBackPage();
    }

    private void openBackPage()
    {
        viewHandler.openBackPage();
    }

    @FXML
    void cancelClick(ActionEvent event) {

    }

    @FXML
    void saveClick(ActionEvent event) throws SQLException, RemoteException {
        clearTextInputs();
    }
    private void clearTextInputs() {
        firstname.setText(null);
        lastName.setText(null);
        emailId.setText(null);
        userId.setText(null);
        address.setText(null);
        phoneNum.setText(null);
        dateOfBirth.setText(null);
    }


}
