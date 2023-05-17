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
    public String addEmployee(String firstName, String lastName,String password, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException, SQLException {

          return    employeeDAO.addEmployee(firstName,lastName,password,UserId,email,address,phoneNum,DateOfBirth);

    }

    @Override
    public ArrayList<Users> viewAllEmployees() throws RemoteException, SQLException {
        return employeeDAO.viewAllEmployees();
    }

    @Override
    public void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) throws RemoteException, SQLException {
        employeeDAO.updateEmployeeInfo(UserId,firstName,lastName,email,address,phoneNum,DateOfBirth);
    }

    @Override
    public void deleteEmployeeById(int UserId) throws RemoteException, SQLException {
        employeeDAO.deleteEmployeeByID(UserId);
    }
}
