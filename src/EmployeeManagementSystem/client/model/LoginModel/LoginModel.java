package EmployeeManagementSystem.client.model.LoginModel;

import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface LoginModel {
    Employee login(int id, String passwd) ;
}
