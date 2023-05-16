package EmployeeManagementSystem.server.DAO.LeaveRequest;

import EmployeeManagementSystem.server.DataBaseConnection;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import java.sql.*;
import java.util.ArrayList;

public class LeaveRequestDaoImpl implements LeaveRequestDao
{
    public LeaveRequestDaoImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public void approveLeave(int shiftID) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection())
        {
          PreparedStatement statement=connection.prepareStatement("DELETE FROM \"shift\" WHERE \"shiftid\"=?");
          PreparedStatement statement2=connection.prepareStatement("DELETE FROM \"leaverequest\" WHERE \"shiftid\"=?");
          statement.setInt(1,shiftID);
          statement2.setInt(2,shiftID);
          statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void rejectLeave(int shiftID) throws SQLException{
        try (Connection connection = DataBaseConnection.getConnection())
        {
            PreparedStatement statement=connection.prepareStatement("DELETE FROM \"leaverequest\" WHERE \"shiftid\"=?");
            statement.setInt(1,shiftID);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<LeaveRequest> viewAllLeaveRequests() throws SQLException{
        ArrayList<LeaveRequest> leaveRequests=new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection())
        {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM \"leaverequest\"");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                int shiftID=resultSet.getInt("shiftid");
                String reason=resultSet.getString("reason");
                LeaveRequest request=new LeaveRequest(shiftID,reason);
                leaveRequests.add(request);
                System.out.println(leaveRequests);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return leaveRequests;
    }
}
