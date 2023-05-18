package EmployeeManagementSystem.client.view.LoginView;

import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.shared.model.Employee;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeLoginViewModel {

    private LoginModel loginModelImpl;
    private StringProperty passwd,message;
    private IntegerProperty id;
    public EmployeeLoginViewModel(LoginModel loginModelImpl) {
        this.loginModelImpl=loginModelImpl;
        initializeAllProperty();
    }

    private void initializeAllProperty() {
        id=new SimpleIntegerProperty();
        passwd=new SimpleStringProperty();
        message = new SimpleStringProperty();
    }

    public LoginModel getLoginModelImpl() {
        return loginModelImpl;
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
        if (passwd.get() == null) {
            message.set("Please enter your password ");

        } else {
            message.set("Tried to access the system");

            return loginModelImpl.login(id.get(), passwd.get());
        }
        return null;
    }
}

