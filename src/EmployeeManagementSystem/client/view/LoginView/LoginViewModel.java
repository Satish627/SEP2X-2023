package EmployeeManagementSystem.client.view.LoginView;

import EmployeeManagementSystem.client.model.Login.LoginModel;
import EmployeeManagementSystem.client.model.Login.LoginModelImpl;
import EmployeeManagementSystem.shared.model.Users;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {

    private LoginModel loginModelImpl;
    private StringProperty userid,passwd;
    public LoginViewModel(LoginModel loginModelImpl) {
        this.loginModelImpl=loginModelImpl;
        initializeAllProperty();
    }

    private void initializeAllProperty() {
        userid=new SimpleStringProperty();
        passwd=new SimpleStringProperty();
    }

    public LoginModel getLoginModelImpl() {
        return loginModelImpl;
    }

    public StringProperty getUserid() {
        return userid;
    }

    public StringProperty getPasswd() {
        return passwd;
    }

    public Users login(){
        if(userid.get().equals(null)||passwd.get().equals(null)){
            System.out.println("Please fill in all information");
            return null;
        }
        else {
            return loginModelImpl.login(Integer.valueOf(userid.get()),passwd.get());
        }
    }

}

