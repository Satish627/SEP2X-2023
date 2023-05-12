package EmployeeManagementSystem.server.DAO.Login;

import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.model.Usertype;

import java.sql.SQLException;

public interface LoginDAO
{
    Users login(String email, String password) throws SQLException;
    Users getUserType(String email, String password, Usertype userType);
}
