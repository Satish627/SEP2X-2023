package EmployeeManagementSystem.client.view.AddEmployee;
import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.util.Random;


public class AddEmployeeController implements ViewController
{
    private ViewHandler viewHandler;
    private AddEmployeeViewModel addEmployeeViewModel;
    @FXML private TextField firstname,lastName,userId,address,emailId,phoneNum,dateOfBirth;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        addEmployeeViewModel = viewModelFactory.getAddEmployeeViewModel();
        bindValuesToTextField();
    }

    private void bindValuesToTextField() {
        firstname.textProperty().bindBidirectional(addEmployeeViewModel.getfirstName());
        lastName.textProperty().bindBidirectional(addEmployeeViewModel.getlastName());
        userId.textProperty().bindBidirectional(addEmployeeViewModel.getUserId());
        address.textProperty().bindBidirectional(addEmployeeViewModel.getAddress());
        emailId.textProperty().bindBidirectional(addEmployeeViewModel.getEmailId());
        phoneNum.textProperty().bindBidirectional(addEmployeeViewModel.getPhoneNum());
        dateOfBirth.textProperty().bindBidirectional(addEmployeeViewModel.getDateOfBirth());

    }

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
    void saveClick(ActionEvent event)  {
        addEmployeeViewModel.addEmployee();


}
}

