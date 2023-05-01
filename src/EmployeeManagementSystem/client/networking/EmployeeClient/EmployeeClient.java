package EmployeeManagementSystem.client.networking.EmployeeClient;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;

public interface EmployeeClient
{
    Users addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) ;
}
