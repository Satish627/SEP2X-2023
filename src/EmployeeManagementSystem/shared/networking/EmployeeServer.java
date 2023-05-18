package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeServer extends Remote {
    String addEmployee(String firstName, String lastName,String password, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException, SQLException;

    ArrayList<Employee> viewAllEmployees() throws RemoteException,SQLException;

    void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException,SQLException;
    void deleteEmployeeById(int UserId) throws RemoteException,SQLException;
}
