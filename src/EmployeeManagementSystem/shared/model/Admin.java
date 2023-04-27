package EmployeeManagementSystem.shared.model;

import java.io.Serializable;

public class Admin extends Users implements Serializable {
    private String userType;
    private int userId;
    private String password;

    public Admin(int userId, String password) {
       super(userId,password);
       this.userType = "Admin";
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

    public String getUserType() {
        return userType;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
