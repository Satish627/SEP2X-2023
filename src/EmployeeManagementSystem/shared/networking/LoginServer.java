package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;

public interface LoginServer
{
Users login(int userid,String passwd) throws RemoteException;
}
