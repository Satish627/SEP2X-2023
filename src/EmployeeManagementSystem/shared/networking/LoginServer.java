package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer extends Remote
{
Users login(int userid,String passwd) throws RemoteException;
}
