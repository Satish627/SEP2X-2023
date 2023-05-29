package EmployeeManagementSystem.client.view.LoginView.AdminLogin;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Admin;
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

import java.util.ArrayList;
import java.util.List;

public class AdminLoginController implements ViewController {
    private ViewHandler viewHandler;
    private AdminLoginViewModel adminLoginViewModel;
    @FXML
    private PasswordField adminPW;

    @FXML
    private TextField adminId;

    @FXML
    private Label messageText;
    @FXML
    private ComboBox<?> selectUserType;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        adminLoginViewModel = viewModelFactory.getAdminLoginViewModel();
        bindValues();
        selectUsers();
    }
    public void selectUsers(){
        List<String> userList = new ArrayList<>();
        for (String data: Users.userType){
            userList.add(data);
        }
        ObservableList list = FXCollections.observableList(userList);
        selectUserType.setItems(list);
    }
    private void bindValues() {
        adminId.textProperty().bindBidirectional(adminLoginViewModel.getAdminId(),new NumberStringConverter());
        adminPW.textProperty().bindBidirectional(adminLoginViewModel.getAdminPW());
        messageText.textProperty().bindBidirectional(adminLoginViewModel.getMessageText());
    }
    public void switchLoginViews(){
        try {
            if (selectUserType.getSelectionModel().getSelectedItem().equals("EMPLOYEE")){
                viewHandler.openLoginView();
            }else {
                viewHandler.openAdminLoginView();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void loginClicked(ActionEvent event) {
        try {
            Admin admin = adminLoginViewModel.adminLogin();
            if ((admin.getUserId()) == ((adminLoginViewModel.getAdminId().get())) && admin.getPassword().equals(adminLoginViewModel.getAdminPW().get())) {
                System.out.println(admin.getUserId());
                viewHandler.openMainView();
            }
        }
        catch (Exception e){
            AlertBox.showAlert(e.getMessage());
        }
    }
    public void cancelClicked(ActionEvent actionEvent) {
        adminId.setText(null);
        adminPW.setText(null);
    }
}

