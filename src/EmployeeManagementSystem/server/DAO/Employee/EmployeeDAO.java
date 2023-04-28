package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.client.model.Employee.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    String addEmployee(String firstName,String lastName, String UserId,String email, String address,String phoneNum, String DateOfBirth);
    ArrayList<Employee> viewAllEmployees();
}
