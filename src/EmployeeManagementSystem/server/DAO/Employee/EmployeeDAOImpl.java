package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.shared.model.Employee;
import org.postgresql.Driver;


import java.sql.*;
import java.util.ArrayList;

import static EmployeeManagementSystem.server.DataBaseConnection.getConnection;

public class EmployeeDAOImpl implements EmployeeDAO
{
    public EmployeeDAOImpl() {
        try{
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String  addEmployee(String firstName, String lastName, String password, int UserId, String email, String address, int phoneNum, String DateOfBirth) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("INSERT INTO employee ( firstname,lastname,passwd,userid,email,address,phonenumber,dateofbirth) VALUES (?,?,?,?,?,?,?,?);");
            newStatement.setString(1, firstName);
            newStatement.setString(2, lastName);
            newStatement.setString(3, password);
            newStatement.setInt(4, UserId);
            newStatement.setString(5, email);
            newStatement.setString(6, address);
            newStatement.setInt(7, phoneNum);
            newStatement.setString(8, DateOfBirth);
            newStatement.executeUpdate();
            connection.close();
            return "Employee added successfully";

           /* PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE userid = ? ");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("userid");
                System.out.println(userId);
                if (userId == UserId) {
                    AlertBox.showAlert("Employee with " + UserId + " already exist");
                }
            }else {
                PreparedStatement newStatement = connection.prepareStatement("INSERT INTO employee ( firstname,lastname,passwd,userid,email,address,phonenumber,dateofbirth) VALUES (?,?,?,?,?,?,?,?);");
                newStatement.setString(1, firstName);
                newStatement.setString(2, lastName);
                newStatement.setString(3, password);
                newStatement.setInt(4, UserId);
                newStatement.setString(5, email);
                newStatement.setString(6, address);
                newStatement.setInt(7, phoneNum);
                newStatement.setString(8, DateOfBirth);
                newStatement.executeUpdate();
                connection.close();
                AlertBox.showAlert("Employee with " + UserId + " already exist");
                return "Employee added successfully";
            }*/
        }
    }


    @Override
    public ArrayList<Employee> viewAllEmployees() throws SQLException {
            ArrayList<Employee> employeeList = new ArrayList<>();
            {try {
                Connection connection = getConnection();
                {
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee ");

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {

                        int userId =resultSet.getInt("userid");
                        String firstName=resultSet.getString("firstname");
                        String lastName = resultSet.getString("lastname");
                        String birthDate = resultSet.getString("dateofbirth");
                        String address = resultSet.getString("address");
                        int phoneNumber = resultSet.getInt("phonenumber");
                        String email =resultSet.getString("email");
                        Employee employee = new Employee(userId,firstName,lastName,birthDate,address,phoneNumber,email);
                        employeeList.add(employee);
                        System.out.println(employeeList);
                        connection.close();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            }
            return employeeList;
        }

    @Override
    public void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("UPDATE  employee SET firstname=?,lastname=?,email=?,address=?,phonenumber=?,dateofbirth=? where userid=?");
            newStatement.setString(1, firstName);
            newStatement.setString(2, lastName);
            newStatement.setString(3, email);
            newStatement.setString(4, address);
            newStatement.setInt(5,phoneNum);
            newStatement.setString(6, DateOfBirth);
            newStatement.setInt(7, UserId);
            newStatement.executeUpdate();
            connection.close();
            System.out.println("Employee information updated successfully");
        }
    }

    @Override
    public void deleteEmployeeByID(int UserId) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("DELETE FROM employee  WHERE userid=?");
            newStatement.setInt(1, UserId);
            newStatement.executeUpdate();
            System.out.println("Employee with employeeId" + UserId + " successfully deleted");
        }
    }
}




