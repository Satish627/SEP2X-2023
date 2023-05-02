package EmployeeManagementSystem.client.view.LoginView;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.model.Usertype;
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
    private void bindValues() {
        userId.textProperty().bindBidirectional(loginViewModel.getUserid());
        password.textProperty().bindBidirectional(loginViewModel.getPasswd());
    }
    @FXML
    void loginClicked(ActionEvent event) {
        viewHandler.openMainView();
    /*    Users usertype = loginViewModel.login();
        if (usertype != null){
            if (usertype.equals(Usertype.ADMIN)){
               viewHandler.openMainView();
            } else if (usertype.equals(Usertype.EMPLOYEE)) {
                viewHandler.openEmployeeView();
            }
        }*/
    }


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        loginViewModel = viewModelFactory.getLoginViewModel();

    }
}
