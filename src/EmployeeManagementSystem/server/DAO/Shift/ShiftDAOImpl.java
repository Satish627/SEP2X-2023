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
            PreparedStatement totalHoursStatement = connection.prepareStatement("SELECT totalhours,status FROM shift WHERE shiftid = ?");
            totalHoursStatement.setInt(1, shiftID);
            ResultSet resultSet = totalHoursStatement.executeQuery();
            int totalHours = 0; // Assuming totalHours is of int type
            String status=null;

            if (resultSet.next()) {
                totalHours = resultSet.getInt("totalhours");
                status=resultSet.getString("status");
            }
            connection.close();
            System.out.println("Shift added successfully");
            return new Shift(shiftID, employeeID,employeeName, date, startTime, endTime,totalHours,status);
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
                    String status=resultSet.getString("status");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String startTimeString = startTime.toLocalTime().format(formatter);
                    String endTimeString = endTime.toLocalTime().format(formatter);
                    Shift shifts = new Shift(shiftID,employeeID,employeeName,date,startTimeString,endTimeString,totalHours,status);
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
                    String status=resultSet.getString("status");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String startTimeString = startTime.toLocalTime().format(formatter);
                    String endTimeString = endTime.toLocalTime().format(formatter);
                    Shift shifts = new Shift(shiftID,employeeID,employeeName,date,startTimeString,endTimeString,totalHours,status);
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
    public void updateShiftInfo(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) throws SQLException {
        try (Connection connection = getConnection()) {
                    PreparedStatement newStatement = connection.prepareStatement("UPDATE  shift SET  shiftid=?,userid=?,employeename=?, date=?, checkintime=?, checkouttime=? where employeename=?");
                    newStatement.setInt(1, shiftID);
                    newStatement.setInt(2, employeeID);
                    newStatement.setString(3, employeeName);
                    newStatement.setDate(4, Date.valueOf(date));
                    newStatement.setTime(5, Time.valueOf(checkInTime));
                    newStatement.setTime(6, Time.valueOf(checkOutTime));
                    newStatement.setString(7, employeeName);
                    newStatement.executeUpdate();
                    connection.close();
                    System.out.println("Shift has been updated");
                }

        }



    @Override
    public void deleteShiftById(int shiftID) throws SQLException
    {
        try
            (Connection connection = getConnection())
            {

                PreparedStatement newStatement = connection.prepareStatement("DELETE FROM shift  WHERE shiftid=?");
                newStatement.setInt(1, shiftID);
                newStatement.executeUpdate();
                connection.close();
                System.out.println("Shift with " + shiftID + " successfully deleted");
            }
        }
    @Override
    public void checkIn(int shiftID, int userID) throws SQLException {
        try (Connection connection = getConnection()) {
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();


            PreparedStatement shiftDateStatement = connection.prepareStatement(
                    "SELECT date FROM shift WHERE shiftID = ?"
            );
            shiftDateStatement.setInt(1, shiftID);
            ResultSet shiftDateResult = shiftDateStatement.executeQuery();

            if (shiftDateResult.next()) {
                LocalDate shiftDate = shiftDateResult.getDate("date").toLocalDate();


                if (currentDate.equals(shiftDate)) {

                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE shift SET checkInTime = ? WHERE shiftID = ? AND userID = ?"
                    );
                    statement.setTime(1, Time.valueOf(currentTime));
                    statement.setInt(2, shiftID);
                    statement.setInt(3, userID);
                    statement.executeUpdate();

                    connection.close();
                    System.out.println("Check-in time set successfully");
                } else {
                    System.out.println("Cannot check in on a different day than the shift");
                }
            } else {
                System.out.println("Shift not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void checkOut(int shiftID, int userID) throws SQLException {
        try (Connection connection = getConnection()) {
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();


            PreparedStatement shiftDateStatement = connection.prepareStatement(
                    "SELECT date FROM shift WHERE shiftID = ?"
            );
            shiftDateStatement.setInt(1, shiftID);
            ResultSet shiftDateResult = shiftDateStatement.executeQuery();

            if (shiftDateResult.next()) {
                LocalDate shiftDate = shiftDateResult.getDate("date").toLocalDate();


                if (currentDate.equals(shiftDate)) {

                    PreparedStatement checkInTimeStatement = connection.prepareStatement(
                            "SELECT checkInTime FROM shift WHERE shiftID = ? AND userID = ?"
                    );
                    checkInTimeStatement.setInt(1, shiftID);
                    checkInTimeStatement.setInt(2, userID);
                    ResultSet checkInTimeResult = checkInTimeStatement.executeQuery();

                    if (checkInTimeResult.next()) {
                        Time checkInTime = checkInTimeResult.getTime("checkInTime");
                        LocalTime checkInLocalTime = checkInTime.toLocalTime();


                        if (currentTime.isAfter(checkInLocalTime)) {

                            PreparedStatement statement = connection.prepareStatement(
                                    "UPDATE shift SET checkOutTime = ? WHERE shiftID = ? AND userID = ?"
                            );
                            statement.setTime(1, Time.valueOf(currentTime));
                            statement.setInt(2, shiftID);
                            statement.setInt(3, userID);
                            statement.executeUpdate();
                            connection.close();
                            System.out.println("Check-out time set successfully");
                        } else {
                            System.out.println("Cannot check out before check-in");
                        }
                    } else {
                        System.out.println("No check-in time found for the specified shift and user");
                    }
                } else {
                    System.out.println("Cannot check out on a different day than the shift");
                }
            } else {
                System.out.println("Shift not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




