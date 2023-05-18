package EmployeeManagementSystem.client.networking.LoginClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class AdminClientImpl implements AdminClient{
    private Server server;

    public AdminClientImpl() {
        try {
            server= GetServer.getRMIServer();
        }catch (Exception e){
            System.out.println("Problem from admin login server!!");
            throw e;
        }
    }
    @Override
    public Admin loginAdmin(int id, String passwd) {
        try
        {
            return server.getLoginServer().loginAdmin(id,passwd);
        }
        catch (RemoteException e){
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }       }
}
