package Shared;

import java.io.Serializable;

public class Admin extends Users implements Serializable {
    private String userType;
    private int userId;
    private String password;

    public Admin(int userId, String password) {
       super(userId,password);
       this.userType = "Admin";
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
