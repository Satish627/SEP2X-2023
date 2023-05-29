package EmployeeManagementSystem.server.networking.Employee;

import EmployeeManagementSystem.server.DAO.Employee.EmployeeDAO;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.networking.EmployeeServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class EmployeeServerImpl implements EmployeeServer {
    private final EmployeeDAO employeeDAO;
    public EmployeeServerImpl(EmployeeDAO employeeDAO) throws RemoteException {
        this.employeeDAO = employeeDAO;
        UnicastRemoteObject.exportObject(this,0);

    }

    @Override
    public Employee addEmployee(String firstName, String lastName,String password, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException  {

          return    employeeDAO.addEmployee(firstName,lastName,password,email,address,phoneNum,DateOfBirth);

    }

    @Override
    public ArrayList<Employee> viewAllEmployees() throws RemoteException  {
        return employeeDAO.viewAllEmployees();
    }

    @Override
    public ArrayList<Employee> viewAllEmployeesWithPassword() throws RemoteException {
        return employeeDAO.viewAllEmployeesWithPassWord();
    }

    @Override
    public void updateEmployeeInfo(int UserId, String firstName, String lastName,String password, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException {
        employeeDAO.updateEmployeeInfo(UserId,firstName,lastName,password,email,address,phoneNum,DateOfBirth);
    }

    @Override
    public void deleteEmployeeById(int UserId) throws RemoteException  {
        employeeDAO.deleteEmployeeByID(UserId);
    }
}
