package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;

import java.awt.*;


public class ViewAllEmployeesController implements ViewController
{
    private Users user;
    @FXML
    private TableView<Users> employeeList;
    @FXML private TableColumn<Users, Integer> userId;
    @FXML private TableColumn<Users, String> firstName;
    @FXML private TableColumn<Users, String> lastName;
    @FXML private TableColumn<Users, String> dateOfBirth;
    @FXML private TableColumn<Users, String> address;
    @FXML private TableColumn<Users, String> phoneNumber;
    @FXML private TableColumn<Users, String> email;
    @FXML
    private Button removeBtn;
    @FXML
    private Button editShiftBtn;
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
       viewHandler.addEmployeeBtn();

    }

    @FXML
    void addShiftClick(ActionEvent event)
    {
        viewHandler.addShiftBtn();
    }


    @FXML
    void editEmployeeAction(ActionEvent event) {
//        int choice = 0;
//        if (employeeList.getUserData() == editShiftBtn) {
//            try {
//                choice = JOptionPane.showConfirmDialog(null, "Are you sure want to edit employee name?" + "\n" + employeeList.getSelectionModel().getSelectedItems().getClass().getName());
//                String input = null;
//                if (choice == JOptionPane.YES_OPTION) {
//                    input = "";
//                    input = JOptionPane.showInputDialog("Enter new employee name: ", JOptionPane.WARNING_MESSAGE);
//                    viewHandler.editEmployee(employeeList.getSelectionModel().getSelectedItem().getFirstName(), input);
//                    JOptionPane.showMessageDialog(null, "Name was changed", "EmployeeList", JOptionPane.INFORMATION_MESSAGE);
//                    initialize();
//                }
//                if (input.equals("")) {
//                    JOptionPane.showMessageDialog(null, "Action was closed. Employee was NOT edited", "Employee List", JOptionPane.INFORMATION_MESSAGE);
//                }
//            } catch (HeadlessException e) {
//                throw new RuntimeException(e);
//            }
//        } else if (choice == JOptionPane.NO_OPTION)
//            JOptionPane.showMessageDialog(null, "Changing was denied. Employee was NOT deleted", "Employee List", JOptionPane.INFORMATION_MESSAGE);
//        else if (choice == JOptionPane.CANCEL_OPTION)
//            JOptionPane.showMessageDialog(null, "Action was closed. Employee  was NOT edited", "Employee List", JOptionPane.INFORMATION_MESSAGE);
//        else if (choice == JOptionPane.CLOSED_OPTION)
//            JOptionPane.showMessageDialog(null, "Action was closed. Employee was NOT edited", "Employee List", JOptionPane.INFORMATION_MESSAGE);
//        {
//            JOptionPane.showMessageDialog(null, "Select a Employee to Edit . Invalid Action", "Employee List", JOptionPane.ERROR_MESSAGE);
//        }
 }

    @FXML
    void removeEmployeeAction(ActionEvent event) {

    }




}
