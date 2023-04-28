package EmployeeManagementSystem.server;

import EmployeeManagementSystem.server.DAO.Employee.EmployeeDAO;
import EmployeeManagementSystem.server.DAO.Employee.EmployeeDAOImpl;
import EmployeeManagementSystem.server.networking.Employee.EmployeeServerImpl;
import EmployeeManagementSystem.server.networking.ServerImpl;
import EmployeeManagementSystem.shared.networking.EmployeeServer;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        EmployeeServer employeeServer = new EmployeeServerImpl(employeeDAO);
        Server server = new ServerImpl(employeeServer);
        server.startServer();
    }
}
