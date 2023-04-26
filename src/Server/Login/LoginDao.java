package Server.Login;

import Shared.Request;

import java.sql.SQLException;

public interface LoginDao
{

    Request login(int userId, String password) throws SQLException;
}
