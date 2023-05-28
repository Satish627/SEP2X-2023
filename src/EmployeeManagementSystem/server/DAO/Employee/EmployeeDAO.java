package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.shared.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {


    Employee  addEmployee(String firstName, String lastName, String password, String email, String address, int phoneNum, String DateOfBirth) ;

    ArrayList<Employee> viewAllEmployees() ;
    void updateEmployeeInfo(int userid,String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) ;
    void deleteEmployeeByID(int UserId) ;
}
