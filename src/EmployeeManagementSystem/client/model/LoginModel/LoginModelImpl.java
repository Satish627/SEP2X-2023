package EmployeeManagementSystem.client.model.LoginModel;

import EmployeeManagementSystem.client.networking.LoginClient.LoginClient;
import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginModelImpl implements LoginModel{
    private LoginClient loginClient;
    private String userType;
    public LoginModelImpl(LoginClient loginClient) {
        this.loginClient=loginClient;
    }

    @Override
    public Users login(String email, String passwd)  {
        return loginClient.login(email,passwd);
    }

    @Override
    public String getUserType() {
        return userType;
    }
}
