package EmployeeManagementSystem.client.networking;

import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GetServer {
    public static Server getRMIServer(){
        Registry registry;
        Server server = null;

        try {
            registry = LocateRegistry.getRegistry(2000);
            server = (Server) registry.lookup("serrrverrrr");
        } catch (RemoteException e) {
            System.out.println("Problem connecting to server");
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return server;
    }

}
