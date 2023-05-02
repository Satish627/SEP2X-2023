package EmployeeManagementSystem.shared.model;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
    private int userId;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String email;
    private int phoneNumber;
    private String dateOfBirth;

    private String userType ;
    private String fullName;


    public Users( String firstName, String lastName,String password,int userId,String email,String address,  int phoneNumber, String  dateOfBirth) {
        this.userId=userId;
        this.firstName = firstName;
        this.lastName= lastName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth= dateOfBirth;
    }

    public Users() {
    }

    public Users(int userid, String passwd) {
        this.userId=userid;
        this.password=passwd;
    }

    public Users(int userid, String passwd, String userType) {
        this.userId=userid;
        this.password=passwd;
        this.userType=userType;
    }

    public Users(int userId, String firstName, String lastName, String dateOfBirth, String address, int phoneNumber, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName= lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth= dateOfBirth;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String  dateOfBirth) {
        dateOfBirth = dateOfBirth;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

}
