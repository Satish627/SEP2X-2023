package EmployeeManagementSystem.client.networking.LoginClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;

public class LoginClientImpl implements LoginClient{
    private Server server;

    public LoginClientImpl() {
        try {
            System.out.println("Hello from  login client networking!!");
            server= GetServer.getRMIServer();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Users login(int userid, String passwd){
        try {
            return server.getLoginServer().login(userid,passwd);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
