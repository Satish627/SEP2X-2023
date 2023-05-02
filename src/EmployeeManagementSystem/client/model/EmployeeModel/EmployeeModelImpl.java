package EmployeeManagementSystem.client.model.EmployeeModel;

import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClient;
import EmployeeManagementSystem.shared.model.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModelImpl implements EmployeeModel
{
    private EmployeeClient employeeClient;
    public EmployeeModelImpl(EmployeeClient employeeClient)
    {
        this.employeeClient = employeeClient;
    }

    @Override
    public Users addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) throws SQLException, RemoteException {
        return employeeClient.addEmployee(firstName,lastName,password,userId,emailId,address,phoneNum,dateOfBirth);
    }

    @Override
    public ArrayList<Users> viewAllEmployees() {
        return employeeClient.viewAllEmployees();
    }

}
