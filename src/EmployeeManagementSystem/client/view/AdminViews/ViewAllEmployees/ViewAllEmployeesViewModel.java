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
    private StringProperty FirstName, LastName, Email, Address;
    private ObjectProperty<LocalDate> dob;
    private StringProperty PhNumber;
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = "abcdefghijklmnopqrstuvwxyz";
    String digits = "0123456789";
    String combination = upper + lower + digits;
    int pwLength = 10;

    String newPassword;
    private final NumberStringConverter numberStringConverter;

    public ViewAllEmployeesViewModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
        employeeList = FXCollections.observableList(employeeModel.viewAllEmployees());
        this.numberStringConverter = new NumberStringConverter();
        employeeModel.addListener("newEmployeeAdded", this::newEmployee);
        employeeModel.addListener("employeeRemoved", this::removeEmployee);
        employeeModel.addListener("employeeUpdated", this::updateEmployee);
        initialiseAllProperty();
    }

    private void initialiseAllProperty() {
        FirstName = new SimpleStringProperty();
        LastName = new SimpleStringProperty();
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

    public ObjectProperty<LocalDate> getDateOfBirth() {
        return dob;
    }

    public ObservableList<Employee> viewAllEmployees() {
        return employeeList;
    }

    private void generatePassword() {
        Random random = new Random();
        char[] com = new char[pwLength];
        for (int i = 0; i < pwLength; i++) {
            com[i] = (combination.charAt(random.nextInt(combination.length())));
        }
        newPassword = new String(com);
        System.out.println("The generated password is : " + newPassword);
    }


    public void editEmployee(int userId, String firstName, String lastName, String dateOfBirth, String address, int phoneNumber, String email) {
        employeeModel.updateEmployee(userId, firstName, lastName, dateOfBirth, address, phoneNumber, email);
    }

    public void deleteEmployee(int uId) {
        employeeModel.deleteEmployee(uId);
    }

    public void addEmployee() {
        if (FirstName.get() == null || FirstName.get().isEmpty()) {
            throw new RuntimeException("First name cannot be empty");
        } else if (LastName.get() == null || LastName.get().isEmpty()) {
            throw new RuntimeException("Last name cannot be empty");
        } else if (dob.get() == null) {
            throw new RuntimeException("Date of birth  cannot be empty");
        } else if (Address.get() == null || Address.get().isEmpty()) {
            throw new RuntimeException("Address cannot be empty");
        } else if (PhNumber.toString() == null || PhNumber.get().isEmpty()) {
            throw new RuntimeException("Phone number cannot be empty or zero");
        } else if (Email.get() == null || Email.get().isEmpty()) {
            throw new RuntimeException("Email name cannot be empty");
        } else {
            try {
                generatePassword();
                employeeModel.addEmployee(FirstName.get(), LastName.get(), newPassword, Email.get(), Address.get(), Integer.parseInt(PhNumber.get()), dateToString(dob.getValue()));
                {
                }
            } catch (SQLException | RemoteException e) {
                throw new RuntimeException(e);
            }
        }
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
