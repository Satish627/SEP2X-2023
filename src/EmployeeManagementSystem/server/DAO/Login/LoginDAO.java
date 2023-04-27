package EmployeeManagementSystem.server.DAO.Login;

import EmployeeManagementSystem.shared.model.Request;

import java.sql.SQLException;

public interface LoginDAO
{
    Request login(int userId, String password) throws SQLException;
}
