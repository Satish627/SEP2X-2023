package EmployeeManagementSystem.client.view.LoginView;

import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
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

    public Users login() {
        try {
            Users savedUser = loginModelImpl.login(Integer.parseInt(String.valueOf((userid.get()))), passwd.get());
            if (savedUser == null) {
                System.out.println("No user");
            } else if ( passwd.get() == null || passwd.get().isEmpty()) {
                System.out.println("Please fill in all information");
            }
            return savedUser;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}

