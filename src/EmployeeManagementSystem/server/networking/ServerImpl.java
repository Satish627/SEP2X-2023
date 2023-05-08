package EmployeeManagementSystem.server.networking;

import EmployeeManagementSystem.shared.networking.EmployeeServer;
import EmployeeManagementSystem.shared.networking.LoginServer;
import EmployeeManagementSystem.shared.networking.Server;
import EmployeeManagementSystem.shared.networking.ShiftServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {
    private EmployeeServer employeeServer;
    private LoginServer loginServer;
    private ShiftServer shiftServer;

    public ServerImpl(EmployeeServer employeeServer, LoginServer loginServer, ShiftServer shiftServer) throws RemoteException {
        this.employeeServer = employeeServer;
        this.loginServer = loginServer;
        this.shiftServer = shiftServer;
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
    public ShiftServer getShiftServer()
    {
        return shiftServer;
    }

}
