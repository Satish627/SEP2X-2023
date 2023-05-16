package EmployeeManagementSystem.client.model.EmployeeModel;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeModel
{
    Users addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) throws SQLException, RemoteException;
    ArrayList<Users> viewAllEmployees();

    void updateEmployee(int UserId,String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth);

    void deleteEmployee(int uId);
}
