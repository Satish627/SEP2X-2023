package EmployeeManagementSystem.shared.model;

import EmployeeManagementSystem.shared.AlertBox;

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
      // checkUserID(userId);
    }

    public Users() {}
    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

   /* private void checkUserID(int userId){
        if (userId<4){
            AlertBox.showAlert("Id should be of length 4 or more");
        }
    }*/

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                '}';
    }

}

