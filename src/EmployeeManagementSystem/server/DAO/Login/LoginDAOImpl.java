package EmployeeManagementSystem.server.DAO.Login;

import EmployeeManagementSystem.server.DAO.DataBaseConnection;
import EmployeeManagementSystem.shared.model.Admin;
import EmployeeManagementSystem.shared.model.Employee;

import java.sql.*;

public class LoginDAOImpl implements LoginDAO {

   @Override
    public Employee login(int id, String passwd) throws SQLException  {
       try( Connection connection= DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE employeeid=? and passwd=?");
            statement.setInt(1, id);
           statement.setString(2,passwd);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                int eId = resultSet.getInt("employeeid");
                String pass = resultSet.getString("passwd");
                return new Employee(eId,pass);
            }
                else{
                    return null;
                }
            }
   }

    @Override
    public Admin loginAdmin(int adminId, String password) throws SQLException {
        try( Connection connection= DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  admin WHERE userid=? and passwd=?");
            statement.setInt(1, adminId);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                int eId = resultSet.getInt("userid");
                String pass = resultSet.getString("passwd");
                return new Admin(eId,pass);
            }
            else{
                return null;
            }
        }
   }

}
