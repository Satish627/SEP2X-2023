package EmployeeManagementSystem.client.view.LoginView.AdminLogin;

import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.shared.model.Admin;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminLoginViewModel {

    private LoginModel loginModel;
    private IntegerProperty adminId;
    private StringProperty adminPW, messageText;

    public AdminLoginViewModel(LoginModel adminLoginModel) {
        this.loginModel = adminLoginModel;
        initializeAllProperty();
    }

    private void initializeAllProperty() {
        adminId = new SimpleIntegerProperty();
        adminPW = new SimpleStringProperty();
        messageText = new SimpleStringProperty();
    }

    public IntegerProperty getAdminId() {
        return adminId;
    }

    public StringProperty getAdminPW() {
        return adminPW;
    }

    public StringProperty getMessageText() {
        return messageText;
    }


    public Admin adminLogin() {
        if ((adminId.get()== 0 || adminId.toString() == null) && (adminPW.get() == null || adminPW.get().isEmpty())) {
            messageText.set("Please enter your user id and password ");

        } else if (adminId.get()== 0 || adminId.toString() == null) {
            messageText.set("Please enter your employee id");
        }
        else if (adminPW.get() == null || adminPW.get().isEmpty()) {
            messageText.set("Please enter your password ");

        } else {
            messageText.set("Tried to access the system");

            return loginModel.adminLogin(adminId.get(), adminPW.get());
        }
        return null;
    }
}
