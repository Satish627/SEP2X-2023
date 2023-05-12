package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface LoginServer extends Remote
{
Users login(String email, String passwd) throws RemoteException,SQLException;

}
