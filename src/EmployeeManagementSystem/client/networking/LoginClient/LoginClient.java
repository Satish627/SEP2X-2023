package EmployeeManagementSystem.client.networking.LoginClient;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginClient extends Remote
{
    Users login(int userid,String passwd);
}
