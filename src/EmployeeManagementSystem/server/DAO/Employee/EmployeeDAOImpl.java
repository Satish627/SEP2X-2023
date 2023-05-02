package EmployeeManagementSystem.server.DAO.Employee;

import EmployeeManagementSystem.shared.model.Users;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;

import static EmployeeManagementSystem.server.DataBaseConnection.getConnection;

public class EmployeeDAOImpl implements EmployeeDAO{
    public EmployeeDAOImpl() {
        try{
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users addEmployee(String firstName, String lastName, String password,int UserId, String email, String address, int phoneNum, String DateOfBirth) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("INSERT INTO Users ( firstname,lastname,passwd,userid,email,address,phonenumber,dateofbirth) VALUES (?,?,?,?,?,?,?,?);");
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
            System.out.println("Employee added successfully");
            return new Users(firstName, lastName, password, UserId, email, address, phoneNum, DateOfBirth);
        }

    }


    @Override
    public ArrayList<Users> viewAllEmployees() throws SQLException {
            ArrayList<Users> employeeList = new ArrayList<>();
            {try {
                Connection connection = getConnection();
                {
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM users ");

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {

                        int userId =resultSet.getInt("userid");
                        String firstName=resultSet.getString("firstname");
                        String lastName = resultSet.getString("lastname");
                        String birthDate = resultSet.getString("dateofbirth");
                        String address = resultSet.getString("address");
                        int phoneNumber = resultSet.getInt("phonenumber");
                        String email =resultSet.getString("email");
                        Users user = new Users(userId,firstName,lastName,birthDate,address,phoneNumber,email);
                        employeeList.add(user);
                        System.out.println(employeeList);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            }
            return employeeList;
        }
    }




