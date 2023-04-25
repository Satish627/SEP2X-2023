package EmployeeManagementSystem.client.view.LoginView;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class LoginController implements ViewController {
    private ViewHandler viewHandler;
    @FXML
    private TextField password;

    @FXML
    private TextField userId;
    private LoginViewModel loginViewModel;
    @FXML
    void loginClicked(ActionEvent event) {
        openMainView();
    }

    private void openMainView() {
        viewHandler.openMainView();
    }

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        loginViewModel = viewModelFactory.getLoginViewModel();

    }
}
