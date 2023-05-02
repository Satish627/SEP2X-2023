package EmployeeManagementSystem.client.model.LoginModel;

import EmployeeManagementSystem.client.networking.LoginClient.LoginClient;
import EmployeeManagementSystem.shared.model.Users;

public class LoginModelImpl implements LoginModel{
    private LoginClient loginClient;
    private String userType;
    public LoginModelImpl(LoginClient loginClient) {
        this.loginClient=loginClient;
    }

    @Override
    public Users login(int userid, String passwd) {
        return loginClient.login(userid,passwd);
    }

    @Override
    public String getUserType() {
        System.out.println("Usertype" + userType);
        return userType;
    }
}
