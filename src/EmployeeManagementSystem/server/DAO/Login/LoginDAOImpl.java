package EmployeeManagementSystem.server.DAO.Login;

import EmployeeManagementSystem.server.DataBaseConnection;
import EmployeeManagementSystem.shared.model.Request;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.model.Usertype;

import java.sql.*;

public class LoginDAOImpl implements LoginDAO {
    public LoginDAOImpl() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
   }

   @Override
    public Users login(int userid, String passwd) throws SQLException {
       try( Connection connection= DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  \"Users\" Where \"userId\"=? and \"password\"=?; ");
            statement.setInt(1, userid);
           statement.setString(2,passwd);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("userid");
                String pass = resultSet.getString("passwd");
                connection.close();
                Users users=new Users(id,pass);
            }
       }
       return new Users(userid,passwd);
    }



    private Users getUserType(int userid,String passwd, String userType) {
            if (userType.equals(Usertype.ADMIN.toString())){
           return new Users(userid,passwd) {
           };


        } else if(userType.equals(Usertype.EMPLOYEE.toString())){
            return new Users(userid,passwd);
        }
            return new Users(userid,passwd,userType);
    }
}
