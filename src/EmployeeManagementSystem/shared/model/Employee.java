package EmployeeManagementSystem.shared.model;

import java.util.Date;

public class Employee extends Users{
    private int userId;
    private String password;

    private String firstName;
    private String lastName;

    private String address;
    private String email;
    private int phoneNumber;
    private Date DateOfBirth;

    private String userType ;

    public Employee( int userId,String password,String firstName, String lastName,String address, String email, int phoneNumber, Date DateOfBirth) {
        super(userId,password);
        this.firstName = firstName;
        this.lastName= lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.DateOfBirth= DateOfBirth;
        this.userType = "EMPLOYEE";
    }

    public Employee() {
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", DateOfBirth=" + DateOfBirth +
                ", userType='" + userType + '\'' +
                '}';
    }
}
