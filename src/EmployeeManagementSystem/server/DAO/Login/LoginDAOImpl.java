package EmployeeManagementSystem.server.DAO.Login;

/*public class LoginDAOImpl implements LoginDAO {
    public LoginDAOImpl() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
   }

   @Override
    public Users login(int userId, String password) throws SQLException {
       try( Connection connection= DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  \"Users\" Where \"userId\"=? and \"password\"=?; ");
            statement.setInt(1, userId);
           statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("userid");
                String passwd = resultSet.getString("passwd");
                connection.close();


                return new Users(id,passwd);
            }
            else{
                connection.close();
                return new User("Username or password incorrect",null);
            }
       }catch (SQLException e)
       {
           return new User(e.getMessage(),null);
       }
   }


    private Users getUserType(int userId,String password, String userType) {
            if (userType.equals(Usertype.ADMIN.toString())){
           return new Users(userId,password) {
           };


        } else if(userType.equals(Usertype.EMPLOYEE.toString())){
            return new Users(userId,password);
        }else
            return new Users(Integer.valueOf(e.getMessage()),null);
    }
}*/
