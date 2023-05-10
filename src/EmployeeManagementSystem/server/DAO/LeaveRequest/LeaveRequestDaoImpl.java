package EmployeeManagementSystem.server.DAO.LeaveRequest;

import EmployeeManagementSystem.server.DataBaseConnection;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

import java.sql.*;
import java.time.LocalDate;

public class LeaveRequestDaoImpl implements LeaveRequestDao
{
    public LeaveRequestDaoImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }


    public LeaveRequest approveLeave(int shiftID,String reason) {
        try {
            Connection connection= DataBaseConnection.getConnection();
            {
                PreparedStatement statement=connection.prepareStatement("SELECT*FROM*\"leaverequest\"WHERE\"shiftId\"=? and\"reason\"=?;");
                statement.setInt(1,shiftID);
                statement.setString(2,reason);
                ResultSet resultSet=statement.executeQuery();
                if(resultSet.next()){
                    PreparedStatement statement2=connection.prepareStatement("DELETE*FROM*\"shift\"WHERE\"shiftId\"=?;");
                    statement2.setInt(1,shiftID);
                    ResultSet resultSet2=statement2.executeQuery();
                    if(resultSet2.next()){
                        int employeeID=resultSet2.getInt("employeeID");
                        LocalDate date= LocalDate.parse(resultSet2.getString("date"));
                        int startTime=resultSet2.getInt("startTime");
                        int endTime=resultSet2.getInt("endTime");
                        Shift shift1=new Shift(shiftID,employeeID,date,startTime,endTime);
                        return new LeaveRequest(shiftID,reason);
                    }
                    else {
                        throw new SQLException();
                    }
                }
                else {
                    throw new SQLException();
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LeaveRequest rejectLeave() {
        return null;
    }
}
