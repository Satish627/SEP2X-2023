package EmployeeManagementSystem.server.networking;

import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerImpl implements Server {
    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {
        //Create registry
        Registry registry = LocateRegistry.createRegistry(2001);
        //bind
        registry.bind("serrrverrrr",this);
        System.out.println("Server started..........");

    }
}
