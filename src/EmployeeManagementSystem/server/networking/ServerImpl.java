package EmployeeManagementSystem.server.networking;

import EmployeeManagementSystem.shared.networking.EmployeeServer;
import EmployeeManagementSystem.shared.networking.LoginServer;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {
    private EmployeeServer employeeServer;
    private LoginServer loginServer;

    public ServerImpl(EmployeeServer employeeServer) throws RemoteException {
        this.employeeServer = employeeServer;
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {
        //Create registry
        Registry registry = LocateRegistry.createRegistry(2001);
        //bind
        registry.bind("serrrverrrr",this);
        System.out.println("Server started..........");

    }
    @Override
    public EmployeeServer getEmployeeServer() {
        return employeeServer;
    }

    @Override
    public LoginServer getLoginServer() {
        return loginServer;
    }
}
