package EmployeeManagementSystem.client.networking.EmployeeClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.networking.Server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeClientImpl implements EmployeeClient
{
    private Server server;
private PropertyChangeSupport propertyChangeSupport;
    public EmployeeClientImpl() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        try {
            System.out.println("Hello from  addEmployee client networking!!");
            server= GetServer.getRMIServer();
        }catch (Exception e){
            throw e;
        }
    }
    @Override
    public ArrayList<Employee> viewAllEmployees() {
        try{
            return server.getEmployeeServer().viewAllEmployees();
        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) {
         try{
           String msg = server.getEmployeeServer().addEmployee(firstName, lastName,password, userId, emailId, address, phoneNum, dateOfBirth);
                propertyChangeSupport.firePropertyChange("newEmployeeAdded", null, new Employee(userId,password,firstName,lastName,emailId,address,phoneNum,dateOfBirth));
            return msg;
         } catch (RemoteException | SQLException e) {
            e.printStackTrace();
         }
        return null;
    }

    @Override
    public void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) {
        try {
            server.getEmployeeServer().updateEmployeeInfo(UserId,firstName,lastName,email,address,phoneNum,DateOfBirth);
            propertyChangeSupport.firePropertyChange("employeeUpdated", null, new Employee(UserId,firstName,lastName,email,address,phoneNum,DateOfBirth));
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(int uId) {
        try {
            server.getEmployeeServer().deleteEmployeeById(uId);
            propertyChangeSupport.firePropertyChange("employeeRemoved", null, new Employee());
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void addListener( String eventName,PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(eventName,listener);
    }
}
