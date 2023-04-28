package EmployeeManagementSystem.client.networking.AddEmployeeClient;

public interface AddEmployeeClient
{
    String addEmployee(String firstName, String lastName, String userId, String emailId, String address, String phoneNum, String dateOfBirth);
}
