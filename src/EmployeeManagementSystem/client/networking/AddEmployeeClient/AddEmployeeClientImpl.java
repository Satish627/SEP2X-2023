package EmployeeManagementSystem.client.networking.AddEmployeeClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.networking.Server;

import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;

public class AddEmployeeClientImpl  implements AddEmployeeClient
{
    private Server server;

    public AddEmployeeClientImpl() {
        try {
            System.out.println("CONNECTED TO Employee client SERVER!!");
            server= GetServer.getRMIServer();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public String addEmployee(String firstName, String lastName, String userId, String emailId, String address, String phoneNum, String dateOfBirth) {
        String employee = null;
        try {
            employee = server.getEmployeeServer().addEmployee(firstName, lastName, userId, emailId, address, phoneNum, dateOfBirth);
            return employee;
        }
        catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
