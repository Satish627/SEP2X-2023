package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.client.model.Employee.Employee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface EmployeeServer extends Remote {
    String addEmployee(String firstName,String lastName, String UserId,String email, String address,String phoneNum, String DateOfBirth) throws RemoteException;
    //ArrayList<Employee> viewAllEmployees();

}
