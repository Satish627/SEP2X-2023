package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.shared.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {


    String  addEmployee(String firstName, String lastName, String password, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws SQLException;

    ArrayList<Employee> viewAllEmployees() throws SQLException;
    void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) throws SQLException;
    void deleteEmployeeByID(int UserId) throws SQLException;
}
