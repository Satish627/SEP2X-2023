package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewAllEmployeesController implements ViewController
{
    @FXML
    private TableView<Users> employeeList;
    @FXML private TableColumn<Users, Integer> userId;
    @FXML private TableColumn<Users, String> firstName;
    @FXML private TableColumn<Users, String> lastName;
    @FXML private TableColumn<Users, String> dateOfBirth;
    @FXML private TableColumn<Users, String> address;
    @FXML private TableColumn<Users, String> phoneNumber;
    @FXML private TableColumn<Users, String> email;
    private ViewHandler viewHandler;
    private ViewAllEmployeesViewModel viewAllEmployeesViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        viewAllEmployeesViewModel = viewModelFactory.getEmployeeViewModel();
        initialiseTableView();
        
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

    @FXML
    void backClick(ActionEvent event)
    {
        backPage();

    }

    private void backPage()
    {
        viewHandler.backPage();
    }
    @FXML
    void addEmployeeClick(ActionEvent event)
    {
        addEmployeeBtn();

    }

    private void addEmployeeBtn()
    {
        viewHandler.addEmployeeBtn();
    }
    @FXML
    void addShiftClick(ActionEvent event)
    {
        openAddShift();
    }

    private void openAddShift() {
        viewHandler.openAddShift();
    }

}
