package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface LoginServer extends Remote
{
Employee login(int id, String passwd) throws RemoteException,SQLException;
    Admin loginAdmin(int id, String passwd) throws RemoteException,SQLException;

}
