package EmployeeManagementSystem.client.networking.LoginClient;

import EmployeeManagementSystem.shared.model.Admin;

public interface AdminClient {
    Admin loginAdmin(int id, String passwd);
}
