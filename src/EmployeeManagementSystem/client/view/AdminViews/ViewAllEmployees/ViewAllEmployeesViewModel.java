package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.shared.model.Employee;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.converter.NumberStringConverter;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ViewAllEmployeesViewModel {
    private EmployeeModel employeeModel;
    private ObservableList<Employee> employeeList;
    private StringProperty FirstName, LastName,Password, Email, Address;
    private ObjectProperty<LocalDate> dob;
    private StringProperty PhNumber;
    private final NumberStringConverter numberStringConverter;

    public ViewAllEmployeesViewModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
        employeeList = FXCollections.observableList(employeeModel.viewAllEmployeesWithPassword());
        this.numberStringConverter = new NumberStringConverter();
        employeeModel.addListener("newEmployeeAdded", this::newEmployee);
        employeeModel.addListener("employeeRemoved", this::removeEmployee);
        employeeModel.addListener("employeeUpdated", this::updateEmployee);
        initialiseAllProperty();
    }

    private void initialiseAllProperty() {
        FirstName = new SimpleStringProperty();
        LastName = new SimpleStringProperty();
        Password = new SimpleStringProperty();
        Email = new SimpleStringProperty();
        Address = new SimpleStringProperty();
        PhNumber = new SimpleStringProperty();
        dob = new SimpleObjectProperty<>();
    }


    public StringProperty getFirstName() {
        return FirstName;
    }


    public StringProperty getLastName() {
        return LastName;
    }


    public StringProperty getEmail() {
        return Email;
    }


    public StringProperty getAddress() {
        return Address;
    }


    public StringProperty getPhNumber() {
        return PhNumber;
    }

    public StringProperty getPassword() {
        return Password;
    }

    public ObjectProperty<LocalDate> getDateOfBirth() {
        return dob;
    }

    public ObservableList<Employee> viewAllEmployees() {
        return employeeList;
    }


    public void editEmployee(int userId, String firstName, String lastName,String password, String dateOfBirth, String address, int phoneNumber, String email) {
        employeeModel.updateEmployee(userId, firstName, lastName,password, dateOfBirth, address, phoneNumber, email);
    }

    public void deleteEmployee(int uId) {
        employeeModel.deleteEmployee(uId);
    }

    private void updateEmployee(PropertyChangeEvent propertyChangeEvent) {
        Employee newUser = (Employee) propertyChangeEvent.getNewValue();
        employeeList.addAll(newUser);
        employeeList.setAll(employeeModel.viewAllEmployees());
    }

    private void removeEmployee(PropertyChangeEvent propertyChangeEvent) {
        employeeList.remove((Employee) propertyChangeEvent.getNewValue());
        employeeList.setAll(employeeModel.viewAllEmployees());
    }

    private String dateToString(LocalDate value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return value.format(formatter);
    }

    private void newEmployee(PropertyChangeEvent propertyChangeEvent) {
        Employee newEmp = (Employee) propertyChangeEvent.getNewValue();
        employeeList.add(newEmp);
        employeeList.setAll(employeeModel.viewAllEmployees());


    }

}
