package EmployeeManagementSystem.server;

import EmployeeManagementSystem.server.networking.ServerImpl;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        Server server = new ServerImpl();
        server.startServer();
    }
}
