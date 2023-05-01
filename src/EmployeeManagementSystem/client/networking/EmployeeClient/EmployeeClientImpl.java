package EmployeeManagementSystem.client.networking.EmployeeClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;

public class EmployeeClientImpl implements EmployeeClient
{
    private Server server;

    public EmployeeClientImpl() {
        try {
            System.out.println("Hello from  addEmployee client networking!!");
            server= GetServer.getRMIServer();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Users addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) {
      try {
          return server.getEmployeeServer().addEmployee(firstName, lastName,password, userId, emailId, address, phoneNum, dateOfBirth);
      }
      catch (RemoteException e){
          e.printStackTrace();
      }
            return null;

}
}
