package EmployeeManagementSystem.client.model.LoginModel;

import EmployeeManagementSystem.client.networking.LoginClient.LoginClient;
import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginModelImpl implements LoginModel{
    private LoginClient loginClient;

    public LoginModelImpl(LoginClient loginClient) {
        this.loginClient=loginClient;
    }

    @Override
    public Employee login(int id, String passwd)  {
        return loginClient.login(id,passwd);
    }

    @Override
    public Admin adminLogin(int id, String passwd) {
        return loginClient.adminLogin(id,passwd);
    }


}
