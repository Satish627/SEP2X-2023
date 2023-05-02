package EmployeeManagementSystem.client.view.AddEmployee;

import EmployeeManagementSystem.client.model.Employee.EmployeeModel;
import EmployeeManagementSystem.shared.model.Users;
import javafx.beans.property.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

public class AddEmployeeViewModel
{
    private EmployeeModel addEmployeeModel;
    private StringProperty firstName,lastName, userId,emailId,address, dateOfBirth, phoneNum;

    String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = "abcdefghijklmnopqrstuvwxyz";
    String digits = "0123456789";
    String combination= upper+lower+digits;
    int pwLength= 10;

    String newPassword ;
    public AddEmployeeViewModel(EmployeeModel addNewEmployee)
    {
    this.addEmployeeModel = addNewEmployee;
    initialiseAllProperty();
    }

    private void initialiseAllProperty() {
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        userId = new SimpleStringProperty();
        emailId = new SimpleStringProperty();
        address = new SimpleStringProperty();
        phoneNum = new SimpleStringProperty();
        dateOfBirth = new SimpleStringProperty();


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

    public StringProperty getfirstName() {
        return firstName;
    }



    public StringProperty getlastName() {
        return lastName;
    }

    public StringProperty getUserId() {
        return userId;
    }


    public StringProperty getEmailId() {
        return emailId;
    }

    public StringProperty getAddress() {
        return address;
    }


    public StringProperty getPhoneNum() {
        return phoneNum;
    }

    public StringProperty getDateOfBirth() {
        return dateOfBirth;
    }


    public Users addEmployee() throws SQLException, RemoteException {
        if (firstName.get()==null || firstName.get().isEmpty() || lastName.get()== null || lastName.get().isEmpty() || userId.get()== null || userId.get().isEmpty() || emailId.get()== null || emailId.get().isEmpty() || address.get()== null || address.get().isEmpty() || phoneNum.get()== null || phoneNum.get().isEmpty() ){
            System.out.println("Please fill in all the information");
            return null;
        }
        else {
           generatePassword();
         return addEmployeeModel.addEmployee(firstName.get(),lastName.get() ,newPassword, Integer.valueOf(userId.get()),emailId.get(),address.get(),Integer.valueOf(phoneNum.get()),dateOfBirth.get());

        }
    }
}
