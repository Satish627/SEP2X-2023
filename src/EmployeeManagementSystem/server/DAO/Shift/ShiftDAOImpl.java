package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;
import javafx.fxml.FXML;
import org.postgresql.Driver;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime localStartTime = LocalTime.parse(startTime, formatter);
            LocalTime localEndTime = LocalTime.parse(endTime, formatter);

            newStatement.setTime(5, Time.valueOf(localStartTime));
            newStatement.setTime(6, Time.valueOf(localEndTime));
            newStatement.executeUpdate();
            PreparedStatement totalHoursStatement = connection.prepareStatement("SELECT totalhours FROM shift WHERE shiftid = ?");
            totalHoursStatement.setInt(1, shiftID);
            ResultSet resultSet = totalHoursStatement.executeQuery();
            int totalHours = 0; // Assuming totalHours is of int type
            if (resultSet.next()) {
                totalHours = resultSet.getInt("totalhours");
            }
            connection.close();
            System.out.println("Shift added successfully");
            return new Shift(shiftID, employeeID,employeeName, date, startTime, endTime,totalHours);
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
                    Time startTime = resultSet.getTime("checkintime");
                    Time endTime = resultSet.getTime("checkouttime");
                    int totalHours=resultSet.getInt("totalhours");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String startTimeString = startTime.toLocalTime().format(formatter);
                    String endTimeString = endTime.toLocalTime().format(formatter);
                    Shift shifts = new Shift(shiftID,employeeID,employeeName,date,startTimeString,endTimeString,totalHours);
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

    public ArrayList<Shift> viewAllShiftByUserID(int userID)
    {
        ArrayList<Shift> shiftList = new ArrayList<>();
        {try{
            Connection connection = getConnection();
            {
                PreparedStatement statement = connection.prepareStatement("SELECT  * FROM shift WHERE userid=?");
                statement.setInt(1,userID);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    int shiftID =resultSet.getInt("shiftid");
                    int employeeID=resultSet.getInt("userid");
                    String employeeName = resultSet.getString("employeeName");
                    LocalDate date = resultSet.getDate("date").toLocalDate();
                    Time startTime = resultSet.getTime("checkintime");
                    Time endTime = resultSet.getTime("checkouttime");
                    int totalHours=resultSet.getInt("totalhours");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String startTimeString = startTime.toLocalTime().format(formatter);
                    String endTimeString = endTime.toLocalTime().format(formatter);
                    Shift shifts = new Shift(shiftID,employeeID,employeeName,date,startTimeString,endTimeString,totalHours);
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

    public void updateShiftInfo(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) throws SQLException
    {
            try (Connection connection = getConnection()) {
                PreparedStatement newStatement = connection.prepareStatement("UPDATE  shift SET shiftId=?,employeeId=?,employeeName=?,date=?,checkInTime=?,checkOutTime=?");
                newStatement.setInt(1, shiftID);
                newStatement.setInt(2, employeeID);
                newStatement.setString(3, employeeName);
                newStatement.setDate(4, Date.valueOf(date));
                newStatement.setTime(5,Time.valueOf(checkInTime));
                newStatement.setTime(6, Time.valueOf(checkOutTime));
                newStatement.executeUpdate();
                connection.close();
                System.out.println("Shift updated successfully");
            }
            catch (SQLException e){
                throw new RuntimeException();
            }
        }

    @Override
    public void checkIn(int shiftID, int userID) throws SQLException {
        try (Connection connection = getConnection()) {
            LocalTime currentTime = LocalTime.now();

            // Update the check-in time for the specified shift and user
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE shift SET checkInTime = ? WHERE shiftID = ? AND userID = ?"
            );
            statement.setTime(1,Time.valueOf(currentTime) );
            statement.setInt(2, shiftID);
            statement.setInt(3, userID);
            statement.executeUpdate();

            connection.close();
            System.out.println("Check-in time set successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void checkOut(int shiftID, int userID) throws SQLException
    {
        try (Connection connection = getConnection()) {
            LocalTime currentTime = LocalTime.now();

            // Update the check-in time for the specified shift and user
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE shift SET checkOutTime = ? WHERE shiftID = ? AND userID = ?"
            );
            statement.setTime(1,Time.valueOf(currentTime) );
            statement.setInt(2, shiftID);
            statement.setInt(3, userID);
            statement.executeUpdate();

            connection.close();
            System.out.println("Check-out time set successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




