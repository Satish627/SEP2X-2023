package EmployeeManagementSystem.client.networking.LoginClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginClientImpl implements LoginClient{
    private Server server;

    public LoginClientImpl() {
        try {
            server= GetServer.getRMIServer();
        }catch (Exception e){
            System.out.println("Problem from login server!!");
            throw e;
        }
    }

    @Override
    public Users login(String email, String passwd)  {
            try
            {
                return server.getLoginServer().login(email,passwd);
            }
            catch (RemoteException e){
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
