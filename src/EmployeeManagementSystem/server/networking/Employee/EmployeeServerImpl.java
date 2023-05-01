package EmployeeManagementSystem.server.networking.Employee;

import EmployeeManagementSystem.server.DAO.Employee.EmployeeDAO;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.networking.EmployeeServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeServerImpl implements EmployeeServer {
    private EmployeeDAO employeeDAO;
    public EmployeeServerImpl(EmployeeDAO employeeDAO) throws RemoteException {
        this.employeeDAO = employeeDAO;
        UnicastRemoteObject.exportObject(this,0);

    }

    @Override
    public Users addEmployee(String firstName, String lastName,String password, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException {
        try {
            return employeeDAO.addEmployee(firstName,lastName,password,UserId,email,address,phoneNum,DateOfBirth);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /*@Override
    public ArrayList<Employee> viewAllEmployees() {
        return employeeDAO.viewAllEmployees();
    }*/
}
