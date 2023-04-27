package server.Login;

import shared.Request;

import java.sql.SQLException;

public interface LoginDAO
{

    Request login(int userId, String password) throws SQLException;
}
