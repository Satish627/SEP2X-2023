package EmployeeManagementSystem.client.networking.LoginClient;

import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Employee;

public interface LoginClient
{
    Employee login(int id, String passwd);
}
