package EmployeeManagementSystem.server.DAO.Login;

import EmployeeManagementSystem.server.DataBaseConnection;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.model.Usertype;

import java.sql.*;

public class LoginDAOImpl implements LoginDAO {

   @Override
    public Users login(String email, String passwd)  {
       try( Connection connection= DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  \"users\" Where \"email\"=? and \"passwd\"=?; ");
            statement.setString(1, email);
           statement.setString(2,passwd);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String email1 = resultSet.getString("email");
                String pass = resultSet.getString("passwd");
                String uType = resultSet.getString("userType");
                connection.close();
                return getUserType(email1,pass, Usertype.valueOf(uType));
            }
                else{
                    connection.close();
                    return new Users("Username or password incorrect",null,null);
                }
            } catch (SQLException e) {
           return new Users(
                   e.getMessage(),null,null);
       }

   }

    @Override
    public Users getUserType(String email, String password, Usertype userType) {
        if (userType.equals(Usertype.ADMIN.toString())) {
            return new Users(email, password) {
            };


        } else if (userType.equals(Usertype.EMPLOYEE.toString())) {
            return new Users(email, password);
        }
        return null;
    }



   /* private Users getUserType(int userid,String passwd, String userType) {
            if (userType.equals(Usertype.ADMIN.toString())){
           return new Users(userid,passwd) {
           };


        } else if(userType.equals(Usertype.EMPLOYEE.toString())){
            return new Users(userid,passwd);
        }
            return new Users(userid,passwd);
    }*/
}
