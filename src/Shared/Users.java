package Shared;

public abstract class Users {
    private int userId;
    private String passWord;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int phoneNumber;
    private String dateOfBirth;

    public Users(int userId, String passWord, String firstName,String lastName,String address,String email, int phoneNumber, String dateOfBirth) {
        this.userId = userId;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Users(int userId, String firstName, String lastName, String passWord) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName= lastName;
        this.passWord = passWord;
    }

    public Users(int userId, String password) {
        this.userId = userId;
        this.passWord = password;
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

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
