package EmployeeManagementSystem.client.model.EmployeeModel;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeModel
{
    Users addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) throws SQLException, RemoteException;

    ArrayList<Users> viewAllEmployees();
}
