package EmployeeManagementSystem.client.view.AddEmployee;

import EmployeeManagementSystem.client.model.Employee.EmployeeModelImpl;
import EmployeeManagementSystem.shared.model.Users;
import javafx.beans.property.*;

import java.rmi.RemoteException;

public class AddEmployeeViewModel
{
    private EmployeeModelImpl addEmployeeModelImpl;
    private StringProperty firstName,lastName, userId,emailId,address, dateOfBirth, phoneNum;
    public AddEmployeeViewModel(EmployeeModelImpl addNewEmployee)
    {
    this.addEmployeeModelImpl = addNewEmployee;
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
    public Users addEmployee() throws RemoteException {
        if (firstName.get()==null || firstName.get().isEmpty() || lastName.get()== null || lastName.get().isEmpty() || userId.get()== null || userId.get().isEmpty() || emailId.get()== null || emailId.get().isEmpty() || address.get()== null || address.get().isEmpty() || phoneNum.get()== null || phoneNum.get().isEmpty() ){
            System.out.println("Please fill in all the information");
            return null;
        }
        else {
        Users employee= addEmployeeModelImpl.addEmployee(firstName.get(),lastName.get(),Integer.valueOf(userId.get()),emailId.get(),address.get(),Integer.valueOf(phoneNum.get()),dateOfBirth.get());
        return employee;
    }
    }
}
