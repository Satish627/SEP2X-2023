package EmployeeManagementSystem.client.model.LoginModel;

import EmployeeManagementSystem.client.networking.LoginClient.AdminClient;
import EmployeeManagementSystem.client.networking.LoginClient.LoginClient;
import EmployeeManagementSystem.shared.model.Admin;

public class AdminLoginModelImpl implements AdminLoginModel{
    private AdminClient adminClient;

    public AdminLoginModelImpl(AdminClient adminClient) {
        this.adminClient=adminClient;
    }
    @Override
    public Admin adminLogin(int id, String passwd) {
        return adminClient.loginAdmin(id,passwd);
    }
}
