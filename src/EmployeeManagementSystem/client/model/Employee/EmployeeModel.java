package EmployeeManagementSystem.client.model.Employee;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface EmployeeModel
{
    Users addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) throws SQLException, RemoteException;
}
