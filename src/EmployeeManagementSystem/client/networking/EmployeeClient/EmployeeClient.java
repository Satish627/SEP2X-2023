package EmployeeManagementSystem.client.networking.EmployeeClient;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeClient
{
    Users addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) ;

    ArrayList<Users> viewAllEmployees();

    void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth );

    void deleteEmployee(int uId);
}
