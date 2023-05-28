package EmployeeManagementSystem.client.view.LoginView.EmployeeLogin;

import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.shared.model.Employee;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeLoginViewModel {

    private LoginModel loginModel;
    private StringProperty passwd,message;
    private IntegerProperty id;
    public EmployeeLoginViewModel(LoginModel loginModel) {
        this.loginModel = loginModel;
        initializeAllProperty();
    }

    private void initializeAllProperty() {
        id=new SimpleIntegerProperty();
        passwd=new SimpleStringProperty();
        message = new SimpleStringProperty();
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public IntegerProperty getId() {
        return id;
    }

    public StringProperty getPasswd() {
        return passwd;
    }

    public StringProperty getMessage() {
        return message;
    }

    public Employee login() {
        if ((id.get()== 0 || id.toString() == null) && (passwd.get() == null || passwd.get().isEmpty())) {
            message.set("Please enter your employee id and password ");

        } else if (id.get()== 0 || id.toString() == null) {
            message.set("Please enter your employee id");
        }
            else if (passwd.get() == null || passwd.get().isEmpty()) {
            message.set("Please enter your password ");

        } else {
            message.set("Tried to login");
            Employee login = loginModel.login(id.get(), passwd.get());
            loginModel.setCurrentUser(login);
            return login;

        }
        return null;
    }
}

