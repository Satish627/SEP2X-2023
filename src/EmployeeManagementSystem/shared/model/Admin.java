package EmployeeManagementSystem.shared.model;

import java.io.Serializable;

public class Admin extends Users implements Serializable {
    public Admin(int UserId,String password){
        super(UserId,password);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
