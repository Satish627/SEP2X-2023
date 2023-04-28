package EmployeeManagementSystem.client.model.AddEmployee;

import EmployeeManagementSystem.client.networking.AddEmployeeClient.AddEmployeeClient;

public class AddEmployeeImpl  implements AddEmployee
{
    private AddEmployeeClient addEmployeeClient;
    public AddEmployeeImpl(AddEmployeeClient addEmployeeClient)
    {
        this.addEmployeeClient = addEmployeeClient;
    }

    @Override
    public String addEmployee(String firstName, String lastName, String userId, String emailId, String address, String phoneNum, String dateOfBirth) {
        return addEmployeeClient.addEmployee(firstName,lastName,userId,emailId,address,phoneNum,dateOfBirth);
    }
}
