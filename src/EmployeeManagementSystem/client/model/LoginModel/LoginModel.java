package EmployeeManagementSystem.client.model.LoginModel;

import EmployeeManagementSystem.shared.model.Users;

public interface LoginModel {
    Users login(int userid,String passwd);
    String getUserType();
}
