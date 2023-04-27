package EmployeeManagementSystem.shared.model;

public abstract class Users {
    private int userId;
    private String passWord;

    public Users() {
    }

    public Users(int userId, String passWord) {
        this.userId = userId;
        this.passWord = passWord;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
