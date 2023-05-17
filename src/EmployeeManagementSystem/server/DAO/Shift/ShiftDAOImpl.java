package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;
import javafx.fxml.FXML;
import org.postgresql.Driver;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static EmployeeManagementSystem.server.DataBaseConnection.getConnection;

public class ShiftDAOImpl implements ShiftDAO
{
    private Connection connection;
    public ShiftDAOImpl()
    {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 @FXML
    public Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime)  {
        try (Connection connection = getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("INSERT INTO shift (shiftid, userid,employeename, date, checkintime, checkouttime) VALUES (?, ?, ?, ?, ?,?);");
            newStatement.setInt(1, shiftID);
            newStatement.setInt(2, employeeID);
            newStatement.setString(3,employeeName);
            newStatement.setDate(4, Date.valueOf(date));
            newStatement.setString(5, startTime);
            newStatement.setString(6, endTime);
         newStatement.executeUpdate();
            connection.close();
            System.out.println("Shift added successfully");
            return new Shift(shiftID, employeeID,employeeName, date, startTime, endTime);
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
 }

    @Override
    public ArrayList<Shift> viewAllShift() throws SQLException {
        ArrayList<Shift> shiftList = new ArrayList<>();
        {try{
            Connection connection = getConnection();
            {
                PreparedStatement statement = connection.prepareStatement("SELECT  * FROM shift");

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    int shiftID =resultSet.getInt("shiftid");
                    int employeeID=resultSet.getInt("userid");
                    String employeeName = resultSet.getString("employeeName");
                    LocalDate date = resultSet.getDate("date").toLocalDate();
                    String startTime = resultSet.getString("checkintime");
                    String endTime = resultSet.getString("checkouttime");
                    Shift shifts = new Shift(shiftID,employeeID,employeeName,date,startTime,endTime);

                    shiftList.add(shifts);
                    System.out.println(shiftList);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }
        return shiftList;
    }

    @Override
    public void deleteShiftById(int shiftID) throws SQLException
    {
        PreparedStatement newStatement = connection.prepareStatement("DELETE FROM shift  WHERE shiftid=?");
        newStatement.setInt(1, shiftID);
        newStatement.executeUpdate();
        connection.close();
        System.out.println("Shift with " + shiftID+ " successfully deleted");
    }



    @Override
    public void updateShiftInfo(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) throws SQLException
    {
            try (Connection connection = getConnection()) {
                PreparedStatement newStatement = connection.prepareStatement("UPDATE  shift SET shiftId=?,employeeId=?,employeeName=?,date=?,checkInTime=?,checkOutTime=?");
                newStatement.setInt(1, shiftID);
                newStatement.setInt(2, employeeID);
                newStatement.setString(3, employeeName);
                newStatement.setDate(4, Date.valueOf(date));
                newStatement.setString(5,checkInTime);
                newStatement.setString(6, checkOutTime);
                newStatement.executeUpdate();
                connection.close();
                System.out.println("Shift updated successfully");
            }
        }





    }



