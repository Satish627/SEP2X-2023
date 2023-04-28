package EmployeeManagementSystem.client.networking.EmployeeClient;

import java.rmi.RemoteException;

public interface EmployeeClient {
    String addEmployee(String firstName,String lastName, String UserId, String email, String address, String phoneNum, String DateOfBirth) throws RemoteException;
}

