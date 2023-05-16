package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.shared.model.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Random;

public class ViewAllEmployeesViewModel {
    private EmployeeModel employeeModel;
    private ObservableList<Users> employeeList;
    private StringProperty FirstName,LastName,Email,Address,DateOfBirth;
    private IntegerProperty UserId,PhNumber;
    String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = "abcdefghijklmnopqrstuvwxyz";
    String digits = "0123456789";
    String combination= upper+lower+digits;
    int pwLength= 10;

    String newPassword ;


    public ViewAllEmployeesViewModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
        employeeList = FXCollections.observableList(employeeModel.viewAllEmployees());
         NumberStringConverter numberStringConverter = new NumberStringConverter();
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

    public ObservableList<Users> viewAllEmployees() {
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

    public Users addEmployee() {
        if (FirstName.get()==null || FirstName.get().isEmpty() || LastName.get()== null || LastName.get().isEmpty()  || Email.get()== null || Email.get().isEmpty() || Address.get()== null || Address.get().isEmpty()){
            System.out.println("Please fill in all the information");
            return null;
        }
        else {
            try {
                generatePassword();
                return employeeModel.addEmployee(FirstName.get(),LastName.get() ,newPassword, UserId.get(),Email.get(),Address.get(),PhNumber.get(),DateOfBirth.get());
            } catch (SQLException | RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
