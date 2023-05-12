package EmployeeManagementSystem.client.view.LoginView;

import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.model.Usertype;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginViewModel {

    private LoginModel loginModelImpl;
    private StringProperty email,passwd,message;
    public LoginViewModel(LoginModel loginModelImpl) {
        this.loginModelImpl=loginModelImpl;
        initializeAllProperty();
    }

    private void initializeAllProperty() {
        email=new SimpleStringProperty();
        passwd=new SimpleStringProperty();
        message = new SimpleStringProperty();
    }

    public LoginModel getLoginModelImpl() {
        return loginModelImpl;
    }

    public StringProperty getEmail() {
        return email;
    }

    public StringProperty getPasswd() {
        return passwd;
    }

    public StringProperty getMessage() {
        return message;
    }

    public Users login() {
        if
        (email.get() == null && passwd.get() == null) {
            message.setValue("Please enter your email and password");
        } else if
        (email.get() == null) {
            message.set("Please enter your email address");

        } else if (passwd.get() == null) {
            message.set("Please enter your password ");

        } else {
            message.set("Tried to access the system");
            return loginModelImpl.login(email.get(), passwd.get());
        }
        return null;
    }
}

