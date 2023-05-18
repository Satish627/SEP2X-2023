package EmployeeManagementSystem.server.DAO.Login;

import EmployeeManagementSystem.server.DataBaseConnection;
import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.model.Usertype;

import java.sql.*;

public class LoginDAOImpl implements LoginDAO {

   @Override
    public Employee login(int id, String passwd)  {
       try( Connection connection= DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  \"employee\" Where \"userid\"=? and \"passwd\"=?; ");
            statement.setInt(1, id);
           statement.setString(2,passwd);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                int eId = resultSet.getInt("userid");
                String pass = resultSet.getString("passwd");
                connection.close();
                return new Employee(eId,pass);
            }
                else{
                    connection.close();
                    return new Employee(0,"Username or password incorrect");
                }
            } catch (SQLException e) {
           return new Employee(
                   0,e.getMessage());
       }
   }

    @Override
    public Admin loginAdmin(int adminId, String password) throws SQLException {
        try( Connection connection= DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  \"admin\" Where \"userid\"=? and \"passwd\"=?; ");
            statement.setInt(1, adminId);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                int eId = resultSet.getInt("userid");
                String pass = resultSet.getString("passwd");
                connection.close();
                return new Admin(eId,pass);
            }
            else{
                connection.close();
                return new Admin(0,"Username or password incorrect");
            }
        } catch (SQLException e) {
            return new Admin(0,e.getMessage());
        }
   }
}
