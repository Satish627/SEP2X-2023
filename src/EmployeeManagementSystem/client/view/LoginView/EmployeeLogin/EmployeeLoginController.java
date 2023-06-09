package EmployeeManagementSystem.client.view.LoginView.EmployeeLogin;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmployeeLoginController implements ViewController {
    private ViewHandler viewHandler;
    @FXML
    private PasswordField password;

    @FXML
    private TextField id;

    @FXML
    private Label message;
    @FXML
    private ComboBox<String> selectUserType;
    private EmployeeLoginViewModel employeeLoginViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        employeeLoginViewModel = viewModelFactory.getLoginViewModel();
        bindValues();
        selectUsers();
    }

    public void selectUsers() {
        List<String> userList = new ArrayList<>();
        Collections.addAll(userList, Users.userType);
        ObservableList<String> list = FXCollections.observableList(userList);
        selectUserType.setItems(list);
    }

    private void bindValues() {
        id.textProperty().bindBidirectional(employeeLoginViewModel.getId(), new NumberStringConverter());
        password.textProperty().bindBidirectional(employeeLoginViewModel.getPasswd());
        message.textProperty().bindBidirectional(employeeLoginViewModel.getMessage());
    }

    public void switchLoginViews() {
        try {
            if (selectUserType.getSelectionModel().getSelectedItem().equals("EMPLOYEE")) {
                viewHandler.openLoginView();
            } else {
                viewHandler.openAdminLoginView();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loginClicked(ActionEvent event) {
        try {
            Employee newEmployee = employeeLoginViewModel.login();
            if ((newEmployee.getUserId()) == ((employeeLoginViewModel.getId().get())) && newEmployee.getPassword().equals(employeeLoginViewModel.getPasswd().get())) {
                System.out.println(newEmployee);
                viewHandler.openEmployeeViewShifts();
            }
        } catch (Exception e) {
            AlertBox.showAlert(e.getMessage());
        }

    }

    public void cancelClicked(ActionEvent actionEvent) {
        id.setText(null);
        password.setText(null);
    }
}
