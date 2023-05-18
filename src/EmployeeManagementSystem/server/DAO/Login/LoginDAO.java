package EmployeeManagementSystem.server.DAO.Login;

import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.model.Usertype;

import java.sql.SQLException;

public interface LoginDAO
{
    Employee login(int employeeId, String password) throws SQLException;
    Admin loginAdmin(int adminId, String password) throws SQLException;
   // Users getUserType(String email, String password, Usertype userType);
}
