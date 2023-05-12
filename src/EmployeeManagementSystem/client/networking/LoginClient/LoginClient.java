package EmployeeManagementSystem.client.networking.LoginClient;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface LoginClient
{
    Users login(String email, String passwd);
}
