package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.server.DataBaseConnection;
import EmployeeManagementSystem.shared.model.Users;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO{
    public EmployeeDAOImpl() {
        try{
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users addEmployee(String firstName, String lastName, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection()) {
                PreparedStatement newStatement = connection.prepareStatement("INSERT INTO users ( firstname,lastname,userid,email,address,phonenumber,dateofbirth) VALUES (?,?,?,?,?,?,?);");
                newStatement.setString(1, firstName);
                newStatement.setString(2, lastName);
                newStatement.setInt(3, UserId);
                newStatement.setString(4, email);
                newStatement.setString(5, address);
                newStatement.setInt(6, phoneNum);
                newStatement.setString(7,DateOfBirth);
                newStatement.executeUpdate();
                connection.close();
            System.out.println( "Employee added successfully");
            return new Users(firstName,lastName,UserId,email,address,phoneNum,DateOfBirth);
            }
    }



    @Override
    public ArrayList<Users> viewAllEmployees() {
        return null;
    }
}
