package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import javax.swing.*;

import java.awt.*;
import java.util.Date;


public class ViewAllEmployeesController implements ViewController
{
    private Users user;
    @FXML
    private MenuItem addEmployeeBtn;

    @FXML
    private MenuItem addShiftBtn;
    @FXML
    private TableView<Users> employeeList;
    @FXML private TableColumn<Users, Integer> userId;
    @FXML private TableColumn<Users, String> firstName;
    @FXML private TableColumn<Users, String> lastName;
    @FXML private TableColumn<Users, String> dateOfBirth;
    @FXML private TableColumn<Users, String> address;
    @FXML private TableColumn<Users, Integer> phoneNumber;
    @FXML private TableColumn<Users, String> email;
    private ViewHandler viewHandler;
    private ViewAllEmployeesViewModel viewAllEmployeesViewModel;

    @FXML private TextField fname;
  @FXML private TextField  lname;
    @FXML private TextField  uId;
    @FXML private TextField  dob;
    @FXML private TextField  Address;
    @FXML private TextField  pNum;
    @FXML private TextField  Email;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        viewAllEmployeesViewModel = viewModelFactory.getEmployeeViewModel();
        initialiseTableView();
        bindTextFieldValues();
    }

    private void initialiseTableView() {
        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        employeeList.setItems(viewAllEmployeesViewModel.viewAllEmployees());
    }
    private void bindTextFieldValues() {
       uId.textProperty().bindBidirectional(viewAllEmployeesViewModel.getUserId(), new NumberStringConverter());
        fname.textProperty().bindBidirectional(viewAllEmployeesViewModel.getFirstName());
        lname.textProperty().bindBidirectional(viewAllEmployeesViewModel.getLastName());
        dob.textProperty().bindBidirectional(viewAllEmployeesViewModel.getDateOfBirth());
        Address.textProperty().bindBidirectional(viewAllEmployeesViewModel.getAddress());
        pNum.textProperty().bindBidirectional(viewAllEmployeesViewModel.getPhNumber(), new NumberStringConverter());
        Email.textProperty().bindBidirectional(viewAllEmployeesViewModel.getEmail());
    }

    @FXML
    void addShiftClick(ActionEvent event)
    {
        viewHandler.openAddShiftView();
    }


    @FXML
    void onEditEmployeeButtonClick(ActionEvent event) {
        viewAllEmployeesViewModel.editEmployee(Integer.parseInt(uId.getText()),fname.getText(),lname.getText(),dob.getText(),Address.getText(),Integer.parseInt(pNum.getText()),Email.getText());
    }
    @FXML
    void menuBarClick(ActionEvent event) {
        if (event.getSource() == addEmployeeBtn) {
            viewHandler.addEmployeeBtn();
        }
        if (event.getSource() == addShiftBtn) {
            viewHandler.openAddShiftView();
        }

    }

@FXML
void getSelectedItem(MouseEvent mouseEvent) {
    int index = employeeList.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        uId.setText(userId.getCellData(index).toString());
    fname.setText(firstName.getCellData(index));
    lname.setText(lastName.getCellData(index));
    dob.setText(dateOfBirth.getCellData(index));
    Address.setText(address.getCellData(index));
    pNum.setText(phoneNumber.getCellData(index).toString());
    Email.setText(email.getCellData(index));

}

    @FXML
    public void onRemoveEmployeeButtonClick(ActionEvent event) {
        viewAllEmployeesViewModel.deleteEmployee(Integer.parseInt(uId.getText())
        );
    }

   @FXML public void onAddEmployeeButtonClick(ActionEvent event) {
       viewAllEmployeesViewModel.addEmployee();
       clearTextInputs();
    }

   @FXML
   public void onBackButtonClick(ActionEvent event) {
        viewHandler.backPage();
    }
    private void clearTextInputs() {
        fname.setText(null);
        lname.setText(null);
        Email.setText(null);
        uId.setText(null);
        Address.setText(null);
        pNum.setText(null);
        dob.setText(null);
    }
}
