package EmployeeManagementSystem.client.view.LoginView.AdminLogin;

import EmployeeManagementSystem.client.model.LoginModel.AdminLoginModel;
import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminLoginViewModel {

    private AdminLoginModel adminLoginModel;
    private IntegerProperty adminId;
    private StringProperty adminPW,messageText;

    public AdminLoginViewModel(AdminLoginModel adminLoginModel) {
        this.adminLoginModel = adminLoginModel;
        initializeAllProperty();
    }
    private void initializeAllProperty() {
        adminId=new SimpleIntegerProperty();
        adminPW=new SimpleStringProperty();
        messageText = new SimpleStringProperty();
    }

    public IntegerProperty getAdminId() {
        return adminId;
    }

    public  StringProperty getAdminPW() {
        return adminPW;
    }

    public StringProperty getMessageText() {
        return messageText;
    }


    public Admin adminLogin() {
        if (adminPW.get() == null) {
            messageText.set("Please enter your password ");

        } else {
            adminPW.set("Tried to access the system");
            return adminLoginModel.adminLogin(adminId.get(), adminPW.get());
        }
        return null;
    }
}
