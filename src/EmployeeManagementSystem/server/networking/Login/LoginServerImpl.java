package EmployeeManagementSystem.server.networking.Login;

import EmployeeManagementSystem.server.DAO.Login.LoginDAO;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.networking.LoginServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class LoginServerImpl implements LoginServer
{
    private LoginDAO loginDAO;

    public LoginServerImpl(LoginDAO loginDAO) throws RemoteException {
        this.loginDAO = loginDAO;
        UnicastRemoteObject.exportObject( this,0);
    }

    @Override
    public Users login(int userid, String passwd) throws RemoteException {
        try {
            return loginDAO.login(userid,passwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
