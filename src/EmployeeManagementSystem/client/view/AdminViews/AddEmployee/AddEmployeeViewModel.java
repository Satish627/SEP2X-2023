package EmployeeManagementSystem.client.view.AdminViews.AddEmployee;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModelImpl;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Employee;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AddEmployeeViewModel {
    private EmployeeModel employeeModel;
    private ObservableList<Employee> employeeList;
    private StringProperty FirstName,LastName,Email,Address;
    private ObjectProperty<LocalDate> dob;
    private StringProperty PhNumber;

    String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = "abcdefghijklmnopqrstuvwxyz";
    String digits = "0123456789";
    String combination= upper+lower+digits;
    int pwLength= 10;

    String newPassword ;
    public AddEmployeeViewModel(EmployeeModelImpl employeeModel) {
        this.employeeModel = employeeModel;
        employeeList = FXCollections.observableList(employeeModel.viewAllEmployees());
        employeeModel.addListener("newEmployeeAdded", this::newEmployee);
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
            } catch (SQLException | RemoteException e) {
                throw new RuntimeException(e);
            }
        }
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
