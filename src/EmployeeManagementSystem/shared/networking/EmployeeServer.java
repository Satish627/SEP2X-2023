package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Employee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface EmployeeServer extends Remote {
    Employee addEmployee(String firstName, String lastName,String password,String email, String address, int phoneNum, String DateOfBirth) throws RemoteException ;

    ArrayList<Employee> viewAllEmployees() throws RemoteException;

    void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException;
    void deleteEmployeeById(int UserId) throws RemoteException;
}
