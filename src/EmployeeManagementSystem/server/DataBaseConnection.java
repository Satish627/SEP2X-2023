package EmployeeManagementSystem.server;

//import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.registerDriver;

public class DataBaseConnection{
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://balarama.db.elephantsql.com:5432/rogtqduv";
        String userName = "rogtqduv";
        String password = "4HRR0fXnlCyVQLS_q3KRcdiWLcpw42zx";
        Connection connection= DriverManager.getConnection(url,userName,password);

        Statement statement=connection.createStatement();
        String schemaName="sep2x";
        statement.executeUpdate("SET search_path TO "+schemaName);
        if (connection !=  null){
            System.out.println("Database connection successfully");
        }
        return connection;
    }
}