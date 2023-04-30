package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface EmployeeServer extends Remote {
    Users addEmployee(String firstName, String lastName, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException;
    //ArrayList<Employee> viewAllEmployees();

}
