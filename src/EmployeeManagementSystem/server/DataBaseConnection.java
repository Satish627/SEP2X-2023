package EmployeeManagementSystem.server;

//import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.registerDriver;

public class DataBaseConnection{
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String password = "0885";
        Connection connection= DriverManager.getConnection(url,userName,password);
        if (connection !=  null){
            System.out.println("Connected to db successfully");
        }
        return connection;
    }
}