package EmployeeManagementSystem.server.DAO.Login;

import EmployeeManagementSystem.shared.model.Request;
import EmployeeManagementSystem.shared.model.Users;

import java.sql.SQLException;

public interface LoginDAO
{
    Users login(int userId, String password) throws SQLException;
}
