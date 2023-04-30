package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.shared.model.Users;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {

    Users addEmployee(String firstName, String lastName, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws SQLException;

    ArrayList<Users> viewAllEmployees();
}
