package Server.Login;

import Shared.Request;

import java.sql.SQLException;

public interface LoginDao
{
    Request login(String username,String password) throws SQLException;
}
