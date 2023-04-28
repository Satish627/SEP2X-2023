package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.client.model.Employee.Employee;
import EmployeeManagementSystem.server.DataBaseConnection;
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
    public String addEmployee(String firstName, String lastName, String UserId, String email, String address, String phoneNum, String DateOfBirth) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from \"employee\" like \"email\"=?;");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                connection.close();
                return "Employee email is already in database";
            } else {
                PreparedStatement newStatement = connection.prepareStatement("INSERT INTO \"employee\"( \"firstname\",\"lastname\",\"employeeid\",\"email\",\"password\",\"phonenumber\",\"dateofbirth\") VALUES (?,?,?,?,?,?,?);");
                newStatement.setString(1, firstName);
                newStatement.setString(2, lastName);
                newStatement.setString(3, UserId);
                newStatement.setString(4, email);
                newStatement.setString(5, address);
                newStatement.setString(6, phoneNum);
                newStatement.setString(7,DateOfBirth);
                newStatement.executeUpdate();
                connection.close();
                return "Employee added successfully";
            }
        } catch (SQLException e) {
            System.out.println("ERROR FROM EmployeeDAOImpl");
            return e.getMessage();
        }     }

    @Override
    public ArrayList<Employee> viewAllEmployees() {
        return null;
    }
}
