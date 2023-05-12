package EmployeeManagementSystem.client.view.LoginView;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.model.Usertype;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController implements ViewController {
    private ViewHandler viewHandler;
    @FXML
    private PasswordField password;

    @FXML
    private TextField email;

    @FXML
    private Label message;
    private LoginViewModel loginViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        loginViewModel = viewModelFactory.getLoginViewModel();
        bindValues();
    }
    private void bindValues() {
        email.textProperty().bindBidirectional(loginViewModel.getEmail());
        password.textProperty().bindBidirectional(loginViewModel.getPasswd());
        message.textProperty().bindBidirectional(loginViewModel.getMessage());
    }
    @FXML
    private void loginClicked(ActionEvent event) {


       viewHandler.openMainView();

      /* String usertype = String.valueOf((loginViewModel.login()));
        String usertype = "Admin";
        if (usertype.equals(Usertype.ADMIN.toString())){
            viewHandler.openMainView();
        } else if (usertype.equals(Usertype.EMPLOYEE.toString())) {
            viewHandler.openViewAllEmployeesView();
        }*/
    }

    public void cancelClicked(ActionEvent actionEvent) {
        email.setText(null);
        password.setText(null);
    }
}
