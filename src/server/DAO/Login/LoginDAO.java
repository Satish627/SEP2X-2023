package server.DAO.Login;

import shared.model.Request;
import shared.model.Users;

import java.sql.SQLException;

public interface LoginDAO
{
    Request login(int userId, String password) throws SQLException;
}
