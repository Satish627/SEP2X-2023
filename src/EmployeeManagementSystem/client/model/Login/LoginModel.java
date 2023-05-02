package EmployeeManagementSystem.client.model.Login;

import EmployeeManagementSystem.shared.model.Users;

public interface LoginModel {
    Users login(int userid,String passwd);
}
