package EmployeeManagementSystem.server;

import EmployeeManagementSystem.server.DAO.Employee.EmployeeDAO;
import EmployeeManagementSystem.server.DAO.Employee.EmployeeDAOImpl;
import EmployeeManagementSystem.server.DAO.Login.LoginDAO;
import EmployeeManagementSystem.server.DAO.Login.LoginDAOImpl;
import EmployeeManagementSystem.server.DAO.Shift.ShiftDAO;
import EmployeeManagementSystem.server.DAO.Shift.ShiftDAOImpl;
import EmployeeManagementSystem.server.networking.Employee.EmployeeServerImpl;
import EmployeeManagementSystem.server.networking.Login.LoginServerImpl;
import EmployeeManagementSystem.server.networking.ServerImpl;
import EmployeeManagementSystem.server.networking.Shift.ShiftServerImpl;
import EmployeeManagementSystem.shared.networking.EmployeeServer;
import EmployeeManagementSystem.shared.networking.LoginServer;
import EmployeeManagementSystem.shared.networking.Server;
import EmployeeManagementSystem.shared.networking.ShiftServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunServer {
    public static void main(String[] args) throws AlreadyBoundException, RemoteException, SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        EmployeeServer employeeServer = new EmployeeServerImpl(employeeDAO);
        LoginDAO loginDAO = new LoginDAOImpl();
        LoginServer loginServer = new LoginServerImpl(loginDAO);
       ShiftDAO shiftDAO = new ShiftDAOImpl();
       ShiftServer shiftServer = new ShiftServerImpl(shiftDAO);
        Server server = new ServerImpl(employeeServer,loginServer,shiftServer);
        server.startServer();


    }
}
