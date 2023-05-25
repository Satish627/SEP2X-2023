package EmployeeManagementSystem.client.model.EmployeeModel;

import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClient;
import EmployeeManagementSystem.shared.model.Employee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class EmployeeModelImpl implements EmployeeModel
{
    private EmployeeClient employeeClient;
    private PropertyChangeSupport propertyChangeSupport;
    public EmployeeModelImpl(EmployeeClient employeeClient)
    {
        this.employeeClient = employeeClient;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        employeeClient.addListener("newEmployeeAdded",this::newEmployeeAdded);
        employeeClient.addListener("employeeRemoved",this::employeeRemoved);
        employeeClient.addListener("employeeUpdated",this::employeeUpdated);
    }

    private void employeeUpdated(PropertyChangeEvent propertyChangeEvent) {
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
    }

    private void employeeRemoved(PropertyChangeEvent propertyChangeEvent) {
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
    }

    @Override
    public String addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth)  {
        return employeeClient.addEmployee(firstName,lastName,password,userId,emailId,address,phoneNum,dateOfBirth);
    }

    @Override
    public ArrayList<Employee> viewAllEmployees() {
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
    public void addListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(eventName,listener);
    }
    private void newEmployeeAdded (PropertyChangeEvent event){
        propertyChangeSupport.firePropertyChange(event);
    }

}
