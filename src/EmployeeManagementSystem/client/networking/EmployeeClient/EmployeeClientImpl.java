package EmployeeManagementSystem.client.networking.EmployeeClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;

public class EmployeeClientImpl  implements EmployeeClient{
    private Server server;

    public EmployeeClientImpl() {
        try
        {
            System.out.println("Connected to employee server");
            server= GetServer.getRMIServer();
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String addEmployee(String firstName, String lastName, String UserId, String email, String address, String phoneNum, String DateOfBirth) throws RemoteException {
        String employee = server.getEmployeeServer().addEmployee(firstName, lastName, UserId, email, address, phoneNum, DateOfBirth);
        return employee;
    }
}
