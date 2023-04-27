package shared;

public class Employee extends Users{
    private int userId;
    private String password;

    private String firstName;
    private String lastName;
    private String userType ;

    public Employee( int userId,String password,String firstName, String lastName) {
        super(userId,password,firstName,lastName);
        this.userType = "EMPLOYEE";
    }

    public Employee(int userId, String password) {
        super(userId,password);
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
