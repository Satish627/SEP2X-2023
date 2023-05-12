package EmployeeManagementSystem.client.model.LoginModel;

import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface LoginModel {
    Users login(String email, String passwd) ;
    String getUserType();
}
