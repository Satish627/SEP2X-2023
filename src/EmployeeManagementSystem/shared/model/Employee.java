package EmployeeManagementSystem.shared.model;

import EmployeeManagementSystem.shared.AlertBox;

import java.io.Serializable;

public class Employee extends Users implements Serializable {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int phoneNumber;
    private String dateOfBirth;

    public Employee(int employeeId,String password, String firstName, String lastName, String address,String email, int phoneNumber, String dateOfBirth){
        super(employeeId,password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(int employeeId, String firstName, String lastName, String dateOfBirth, String address, int phoneNumber, String email) {
        super(employeeId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee() {}

    public Employee(int employeeId , String password) {
        super(employeeId,password);
    }

    public Employee(String firstName, String lastName, String dateOfBirth, String address, int phoneNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNum;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setEmployeeId(int employeeId) {
       setUserId(employeeId);
    }
}
