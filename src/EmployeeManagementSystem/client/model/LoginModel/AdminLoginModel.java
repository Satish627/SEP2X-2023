package EmployeeManagementSystem.client.model.LoginModel;

import EmployeeManagementSystem.shared.model.Admin;

public interface AdminLoginModel {
    Admin adminLogin(int id, String passwd);

}
