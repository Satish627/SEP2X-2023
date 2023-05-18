package EmployeeManagementSystem.shared.model;

import java.io.Serializable;

public abstract class Users implements Serializable {
    private static  final long serialVersionUID = 7548777030362684667L;
    private int userId;
    private String password;

    public static String [] userType ={"ADMIN","EMPLOYEE"};


    public Users(int userId, String password) {
        this.userId=userId;
        this.password = password;
    }


    public Users(int userId) {
       this.userId = userId;
    }

    public Users() {

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                ", password='" + password + '\'' +
                '}';
    }

}

