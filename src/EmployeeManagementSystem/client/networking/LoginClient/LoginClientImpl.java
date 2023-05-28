package EmployeeManagementSystem.client.networking.LoginClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginClientImpl implements LoginClient{
    private Server server;
    private boolean hasConnectedToServer;

    public LoginClientImpl() {

    }

    private void connectToServer() {
        try {
            server= GetServer.getRMIServer();
        }catch (Exception e){
            System.out.println("Problem from login server!!");
            throw e;
        }
    }

    @Override
    public Employee login(int id, String passwd)  {
        checkServerConnection();
        try
            {
                return server.getLoginServer().login(id,passwd);
            }
            catch (RemoteException e){
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    private void checkServerConnection() {
        if (!hasConnectedToServer){
            connectToServer();
            hasConnectedToServer = true;
        }
    }

    @Override
    public Admin adminLogin(int id, String passwd) {
        checkServerConnection();
        try
        {
            return server.getLoginServer().loginAdmin(id,passwd);
        }
        catch (RemoteException e){
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

}
