package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.server.DAO.DataBaseConnection;
import EmployeeManagementSystem.shared.model.Employee;
import org.postgresql.Driver;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;


public class EmployeeDAOImpl implements EmployeeDAO {
    public EmployeeDAOImpl() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, String password, String email,
                                String address, int phoneNum, String dateOfBirth) {
        try (Connection connection = DataBaseConnection.getInstance().getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("INSERT INTO employee ( firstname,lastname,passwd," +
                    "email,address,phonenumber,dateofbirth) VALUES (?,?,?,?,?,?,?);");
            newStatement.setString(1, firstName);
            newStatement.setString(2, lastName);
            newStatement.setString(3, password);
            newStatement.setString(4, email);
            newStatement.setString(5, address);
            newStatement.setInt(6, phoneNum);
            newStatement.setDate(7, stringToDate(dateOfBirth));
           int affectedRows= newStatement.executeUpdate();
           Employee employee = new Employee(firstName, lastName, dateOfBirth, address, phoneNum, email);
            if (affectedRows > 0) {
                ResultSet generatedKeys = newStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int employeeId = generatedKeys.getInt(1);
                    employee.setEmployeeId(employeeId);
                }
            }
            return employee;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Date stringToDate(String dateOfBirth) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return new Date(dateFormat.parse(dateOfBirth).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ArrayList<Employee> viewAllEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        {
            try(Connection connection = DataBaseConnection.getInstance().getConnection()) {

                {
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee ");

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {

                        int employeeid = resultSet.getInt("employeeid");
                        String firstName = resultSet.getString("firstname");
                        String lastName = resultSet.getString("lastname");
                        String birthDate = resultSet.getString("dateofbirth");
                        String address = resultSet.getString("address");
                        int phoneNumber = resultSet.getInt("phonenumber");
                        String email = resultSet.getString("email");
                        Employee employee = new Employee(employeeid, firstName, lastName, birthDate, address, phoneNumber, email);
                        employeeList.add(employee);
                        System.out.println(employeeList);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return employeeList;
    }

    @Override
    public ArrayList<Employee> viewAllEmployeesWithPassWord() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        {
            try(Connection connection = DataBaseConnection.getInstance().getConnection()) {

                {
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee ");

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {

                        int employeeid = resultSet.getInt("employeeid");
                        String firstName = resultSet.getString("firstname");
                        String lastName = resultSet.getString("lastname");
                        String password = resultSet.getString("passwd");
                        String birthDate = resultSet.getString("dateofbirth");
                        String address = resultSet.getString("address");
                        int phoneNumber = resultSet.getInt("phonenumber");
                        String email = resultSet.getString("email");
                        Employee employee = new Employee(employeeid, firstName, lastName, password,birthDate, address, phoneNumber, email);
                        employeeList.add(employee);
                        System.out.println(employeeList);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return employeeList;
    }

    @Override
    public void updateEmployeeInfo(int employeeid, String firstName, String lastName, String password,String email, String address, int phoneNum, String DateOfBirth) {
        try {
            try (Connection connection = DataBaseConnection.getInstance().getConnection()) {
                PreparedStatement newStatement = connection.prepareStatement("UPDATE  employee SET firstname=?,lastname=?,address=?,email=?,phonenumber=?, dateofbirth=? where employeeid=?");
                newStatement.setString(1, firstName);
                newStatement.setString(2, lastName);
                newStatement.setString(3, password);
                newStatement.setString(4, address);
                newStatement.setString(5, email);
                newStatement.setInt(6, phoneNum);
                newStatement.setString(7, DateOfBirth);
                newStatement.setInt(8, employeeid);
                newStatement.executeUpdate();
                connection.close();
                System.out.println("Employee information updated successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployeeByID(int employeeid) {
        try {
            try (Connection connection = DataBaseConnection.getInstance().getConnection()) {
                PreparedStatement newStatement = connection.prepareStatement("DELETE FROM employee  WHERE employeeid=?");
                newStatement.setInt(1, employeeid);
                newStatement.executeUpdate();
                System.out.println("Employee with employeeId" + employeeid + " successfully deleted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




