package EmployeeManagementSystem.client.view.AddEmployee;

import EmployeeManagementSystem.client.model.AddEmployee.AddEmployeeImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddEmployeeViewModel
{
    private AddEmployeeImpl addEmployeeModelImpl;
    private StringProperty firstName,lastName, userId,emailId,address,phoneNum, dateOfBirth;
    public AddEmployeeViewModel(AddEmployeeImpl addNewEmployee)
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
    public String addEmployee(){
        String employee= addEmployeeModelImpl.addEmployee(firstName.get(),lastName.get(),userId.get(),emailId.get(),address.get(),phoneNum.get(),dateOfBirth.get());
        return employee;
    }
}
