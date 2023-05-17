package EmployeeManagementSystem.client.model.EmployeeModel;

import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClient;
import EmployeeManagementSystem.shared.model.Users;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModelImpl implements EmployeeModel
{
    private EmployeeClient employeeClient;
    private PropertyChangeSupport propertyChangeSupport;
    public EmployeeModelImpl(EmployeeClient employeeClient)
    {
        this.employeeClient = employeeClient;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        employeeClient.addListener(this::newEmployeeAdded);
       // employeeClient.addListener(this::removeEmployee);
    }

    private void removeEmployee(PropertyChangeEvent propertyChangeEvent) {
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
        System.out.println("Employee removed from employee model");
    }

    @Override
    public String addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth)  {
        return employeeClient.addEmployee(firstName,lastName,password,userId,emailId,address,phoneNum,dateOfBirth);
    }

    @Override
    public ArrayList<Users> viewAllEmployees() {
        return employeeClient.viewAllEmployees();
    }

    @Override
    public void updateEmployee(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) {
        employeeClient.updateEmployeeInfo(UserId, firstName,lastName,email,address,phoneNum,DateOfBirth);
    }

    @Override
    public void deleteEmployee(int uId) {
        employeeClient.deleteEmployee(uId);
    }


    @Override
    public void addListener( PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(eventName,listener);

    }
    private void newEmployeeAdded (PropertyChangeEvent event){
        propertyChangeSupport.firePropertyChange(event);
        System.out.println("Employee added from employee model");
    }

}
