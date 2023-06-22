package EmployeeManagementSystem.server.DAO;

//import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.registerDriver;
/*public static Connection getConnection() throws SQLException {
      String schemaName="sep2x";

      String url = "jdbc:postgresql://balarama.db.elephantsql.com:5432/rogtqduv?currentSchema="+schemaName;
      String userName = "rogtqduv";
      String password = "4HRR0fXnlCyVQLS_q3KRcdiWLcpw42zx";
      Connection connection= DriverManager.getConnection(url,userName,password);

      Statement statement=connection.createStatement();
      statement.executeUpdate("SET search_path TO "+schemaName);
      if (connection !=  null){
          System.out.println("Database connection successfully");
      }
      return connection;
  }*/
public class DataBaseConnection{
    private static DataBaseConnection instance;
    private Connection connection;
    String schemaName="sep2x";
    String url = "jdbc:postgresql://balarama.db.elephantsql.com:5432/rogtqduv?currentSchema="+schemaName;
    String userName = "rogtqduv";
    String password = "4HRR0fXnlCyVQLS_q3KRcdiWLcpw42zx";

    private DataBaseConnection() {}
    public static DataBaseConnection getInstance() {
        if (instance == null) {
            synchronized (DataBaseConnection.class) {
                if (instance == null) {
                    instance = new DataBaseConnection();
                }
            }
        }
        return instance;
    }
    public Connection getConnection() {
            try {
                connection = DriverManager.getConnection(url, userName, password);
                Statement statement=connection.createStatement();
                statement.executeUpdate("SET search_path TO "+schemaName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return connection;
    }
}