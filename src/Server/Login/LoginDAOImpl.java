package Server.Login;

import Server.DataBaseConnection;
import Shared.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDao {
    public LoginDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    @Override
    public Request login(String username, String password) throws SQLException {
        Connection connection= DataBaseConnection.getConnection(){
            PreparedStatement statement
        };
    }
}
