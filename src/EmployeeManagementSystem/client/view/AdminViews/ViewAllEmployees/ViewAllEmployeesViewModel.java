package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Employee;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.converter.NumberStringConverter;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Random;

public class ViewAllEmployeesViewModel {
    private EmployeeModel employeeModel;
    private ObservableList<Employee> employeeList;
    private StringProperty FirstName,LastName,Email,Address,DateOfBirth;
    private IntegerProperty UserId,PhNumber;
    String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = "abcdefghijklmnopqrstuvwxyz";
    String digits = "0123456789";
    String combination= upper+lower+digits;
    int pwLength= 10;

    String newPassword ;
    private final NumberStringConverter numberStringConverter;

    public ViewAllEmployeesViewModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
        employeeList = FXCollections.observableList(employeeModel.viewAllEmployees());
        this.numberStringConverter = new NumberStringConverter();
        employeeModel.addListener("newEmployeeAdded",this::newEmployee);
       employeeModel.addListener("employeeRemoved",this::removeEmployee);
        employeeModel.addListener("employeeUpdated",this::updateEmployee);
        initialiseAllProperty();
    }

    private void initialiseAllProperty() {
        FirstName = new SimpleStringProperty();
        LastName = new SimpleStringProperty();
        UserId = new SimpleIntegerProperty();
        Email = new SimpleStringProperty();
        Address = new SimpleStringProperty();
        PhNumber = new SimpleIntegerProperty();
        DateOfBirth = new SimpleStringProperty();
    }

    public IntegerProperty getUserId() {
        return UserId;
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


    public IntegerProperty getPhNumber() {
        return PhNumber;
    }

    public StringProperty getDateOfBirth() {
        return DateOfBirth;
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


    public void editEmployee(int userId, String firstName, String lastName,String dateOfBirth,String address,int phoneNumber, String email) {
        employeeModel.updateEmployee(userId,firstName,lastName,dateOfBirth,address,phoneNumber,email);
    }

    public void deleteEmployee(int uId) {
        employeeModel.deleteEmployee(uId);
    }

    public String addEmployee() {

        if ((UserId.get()== 0 || UserId.toString() == null) && (FirstName.get()==null || FirstName.get().isEmpty()) && (LastName.get()== null || LastName.get().isEmpty())  && (Email.get()== null || Email.get().isEmpty()) && (PhNumber.get()==0 || PhNumber.toString() == null) && (DateOfBirth.get()==null || DateOfBirth.get().isEmpty()) && (Address.get()== null || Address.get().isEmpty()))
             {
           AlertBox.showAlert ("Please fill in all the information");
        } else if (UserId.toString() == null||UserId.get() == 0  ) {
            AlertBox.showAlert ("User id cannot be empty or zero");
        } else if (FirstName.get() == null || FirstName.get().isEmpty()) {
            AlertBox.showAlert ("First name cannot be empty");
        } else if (LastName.get() == null||LastName.get().isEmpty()) {
            AlertBox.showAlert ("Last name cannot be empty");
        }
        else if (DateOfBirth.get() == null || DateOfBirth.get().isEmpty()) {
            AlertBox.showAlert ("Date of birth  cannot be empty");
        } else if (Address.get() == null||Address.get().isEmpty()) {
            AlertBox.showAlert ("Address cannot be empty");
        }else if ( PhNumber.toString()==null||PhNumber.get() ==0) {
            AlertBox.showAlert ("Phone number cannot be empty or zero");
        }
        else if (Email.get() == null || Email.get().isEmpty()) {
            AlertBox.showAlert("Email name cannot be empty");
        }else {
            try {
                generatePassword();
                employeeModel.addEmployee(FirstName.get(),LastName.get() ,newPassword, UserId.get(),Email.get(),Address.get(),PhNumber.get(),DateOfBirth.get()); {
                    return null;
                }
            } catch (SQLException | RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
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

    private void newEmployee(PropertyChangeEvent propertyChangeEvent) {
        Employee newEmp = (Employee) propertyChangeEvent.getNewValue();
        employeeList.add(newEmp);
        employeeList.setAll(employeeModel.viewAllEmployees());


    }

}
