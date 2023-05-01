package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeServer extends Remote {
    Users addEmployee(String firstName, String lastName,String password, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException, SQLException;
    //ArrayList<Employee> viewAllEmployees();

}
