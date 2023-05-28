package EmployeeManagementSystem.client.networking.EmployeeClient;

import EmployeeManagementSystem.shared.Subject;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeClient extends Subject
{
    String addEmployee(String firstName, String lastName,String password, String emailId, String address, int phoneNum, String dateOfBirth) ;

    ArrayList<Employee> viewAllEmployees();

    void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth );

    void deleteEmployee(int uId);
}
