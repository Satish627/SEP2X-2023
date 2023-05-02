package EmployeeManagementSystem.client.model.Login;

import EmployeeManagementSystem.client.networking.LoginClient.LoginClient;
import EmployeeManagementSystem.shared.model.Users;

public class LoginModelImpl implements LoginModel{
    private LoginClient loginClient;
    public LoginModelImpl(LoginClient loginClient) {
        this.loginClient=loginClient;
    }

    @Override
    public Users login(int userid, String passwd) {
        return loginClient.login(userid,passwd);
    }
}
