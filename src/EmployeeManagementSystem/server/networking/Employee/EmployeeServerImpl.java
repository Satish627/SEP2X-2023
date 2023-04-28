package EmployeeManagementSystem.server.networking.Employee;

import EmployeeManagementSystem.client.model.Employee.Employee;
import EmployeeManagementSystem.server.DAO.Employee.EmployeeDAO;
import EmployeeManagementSystem.shared.networking.EmployeeServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class EmployeeServerImpl implements EmployeeServer {
    private EmployeeDAO employeeDAO;
    public EmployeeServerImpl(EmployeeDAO employeeDAO) throws RemoteException {
        this.employeeDAO = employeeDAO;
        UnicastRemoteObject.exportObject(this,0);

    }

    @Override
    public String addEmployee(String firstName, String lastName, String UserId, String email, String address, String phoneNum, String DateOfBirth) throws RemoteException{
        return employeeDAO.addEmployee(firstName,lastName,UserId,email,address,phoneNum,DateOfBirth);
    }

    /*@Override
    public ArrayList<Employee> viewAllEmployees() {
        return employeeDAO.viewAllEmployees();
    }*/
}
