//package Server.Login;
//
//import Server.DataBaseConnection;
//import Shared.Admin;
//import Shared.Employee;
//import Shared.Request;
//import Shared.Usertype;
//
//import java.sql.*;
//
//public class LoginDAOImpl implements LoginDao {
//    public LoginDAOImpl() throws SQLException
//    {
////        DriverManager.registerDriver(new org.postgresql.Driver());
//    }
//
//   @Override
//    public Request login(String userId, String password) throws SQLException {
//       try( Connection connection= DataBaseConnection.getConnection()){
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  \"Users\" Where \"userId\"=? and \"password\"=?; ");
//            statement.setString(1,userId);
//           statement.setString(2,password);
//            ResultSet resultSet = statement.executeQuery();
//            if(resultSet.next()){
//                String firstName = resultSet.getString("firstname");
//                String lastName =resultSet.getString("lastname");
//                String accessType = resultSet.getString("access_type");
//                connection.close();
////                return getUserType(firstName,lastName,userId,accessType);
//            }
//            else {
//                connection.close();
//                return new Request("Invalid Credentials",null);
//            }}
//       catch(SQLException e){
//                return new Request(e.getMessage(),null);
//           }
//        }
//
//
//    private void getUserType(String firstName, String lastName, String userId, String accessType) {
//        /*     if (accessType.equals(Usertype.ADMIN.toString())){
//            return new Request(Usertype.ADMIN.toString(), new Admin(firstname,lastname,username));
//
//
//        } else if(accessType.equals(Usertype.EMPLOYEE.toString())){
//            return new Request(Usertype.EMPLOYEE.toString(),new Employee(firstname,lastname,username));
//        }else
//            return new Request("Something went wrong in database",null);
//    }*/
//}
