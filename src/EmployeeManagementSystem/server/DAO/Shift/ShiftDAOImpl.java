package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;
import javafx.fxml.FXML;
import org.postgresql.Driver;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static EmployeeManagementSystem.server.DAO.DataBaseConnection.getConnection;

public class ShiftDAOImpl implements ShiftDAO {

    public ShiftDAOImpl() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Shift addShift(int employeeID, LocalDate date, String startTime, String endTime) {
        try (Connection connection = getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("INSERT INTO shift (employeeid, date, checkintime, checkouttime) VALUES (?, ?, ?, ?);");
            newStatement.setInt(1, employeeID);
            newStatement.setDate(2, Date.valueOf(date));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime localStartTime = LocalTime.parse(startTime, formatter);
            LocalTime localEndTime = LocalTime.parse(endTime, formatter);

            newStatement.setTime(3, Time.valueOf(localStartTime));
            newStatement.setTime(4, Time.valueOf(localEndTime));
            int affectedRows = newStatement.executeUpdate();
            Shift shift = new Shift( employeeID, date, startTime, endTime, getEmployeeNameFromEmployeeId(employeeID));

            if (affectedRows > 0) {
                ResultSet generatedKeys = newStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int shiftId = generatedKeys.getInt(1);
                    shift.setShiftID(shiftId);
                }
            }
            return shift;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Shift> viewAllShift() throws SQLException {
        ArrayList<Shift> shiftList = new ArrayList<>();
        {
            try ( Connection connection = getConnection()){

                {
                    PreparedStatement statement = connection.prepareStatement("SELECT  * FROM shift");

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        int shiftID = resultSet.getInt("shiftid");
                        int employeeID = resultSet.getInt("employeeid");
                        LocalDate date = resultSet.getDate("date").toLocalDate();
                        Time startTime = resultSet.getTime("checkintime");
                        Time endTime = resultSet.getTime("checkouttime");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String startTimeString = startTime.toLocalTime().format(formatter);
                        String endTimeString = endTime.toLocalTime().format(formatter);
                        Shift shifts = new Shift(shiftID, employeeID, date, startTimeString, endTimeString,getEmployeeNameFromEmployeeId(employeeID));
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

    public ArrayList<Shift> viewAllShiftByemployeeid(int employeeid) {
        ArrayList<Shift> shiftList = new ArrayList<>();
        {
            try(Connection connection = getConnection()) {

                {
                    PreparedStatement statement = connection.prepareStatement("SELECT  * FROM shift WHERE employeeid=?");
                    statement.setInt(1, employeeid);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {

                        int shiftID = resultSet.getInt("shiftid");
                        int employeeID = resultSet.getInt("employeeid");
                        LocalDate date = resultSet.getDate("date").toLocalDate();
                        Time startTime = resultSet.getTime("checkintime");
                        Time endTime = resultSet.getTime("checkouttime");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String startTimeString = startTime.toLocalTime().format(formatter);
                        String endTimeString = endTime.toLocalTime().format(formatter);
                        Shift shifts = new Shift(shiftID, employeeID, date, startTimeString, endTimeString,getEmployeeNameFromEmployeeId(employeeID));
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

    private String getEmployeeNameFromEmployeeId(int employeeid) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT firstname FROM employee WHERE employeeid =?");
            statement.setInt(1, employeeid);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return resultSet.getString("firstname");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Shift updateShiftInfo(Shift shift) {
        try (Connection connection = getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("UPDATE  shift SET date=?, checkintime=?, checkouttime=? where shiftid=?");
            newStatement.setDate(1, Date.valueOf(shift.getDate()));
            newStatement.setTime(2, Time.valueOf(shift.getCheckInTime()));
            newStatement.setTime(3, Time.valueOf(shift.getCheckOutTime()));
            newStatement.setInt(4,shift.getShiftID());
            newStatement.executeUpdate();
            connection.close();
            System.out.println("Shift has been updated");
            return shift.copy();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteShiftById(int shiftID) throws SQLException {
        try
                (Connection connection = getConnection()) {

            PreparedStatement newStatement = connection.prepareStatement("DELETE FROM shift  WHERE shiftid=?");
            newStatement.setInt(1, shiftID);
            newStatement.executeUpdate();
            connection.close();
            System.out.println("Shift with " + shiftID + " successfully deleted");
        }
    }

    @Override
    public void checkIn(int shiftID, int employeeid) throws SQLException {
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
                            "UPDATE shift SET checkInTime = ? WHERE shiftID = ? AND employeeid = ?"
                    );
                    statement.setTime(1, Time.valueOf(currentTime));
                    statement.setInt(2, shiftID);
                    statement.setInt(3, employeeid);
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
    public void checkOut(int shiftID, int employeeid) throws SQLException {
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
                            "SELECT checkInTime FROM shift WHERE shiftID = ? AND employeeid = ?"
                    );
                    checkInTimeStatement.setInt(1, shiftID);
                    checkInTimeStatement.setInt(2, employeeid);
                    ResultSet checkInTimeResult = checkInTimeStatement.executeQuery();

                    if (checkInTimeResult.next()) {
                        Time checkInTime = checkInTimeResult.getTime("checkInTime");
                        LocalTime checkInLocalTime = checkInTime.toLocalTime();


                        if (currentTime.isAfter(checkInLocalTime)) {

                            PreparedStatement statement = connection.prepareStatement(
                                    "UPDATE shift SET checkOutTime = ? WHERE shiftID = ? AND employeeid = ?"
                            );
                            statement.setTime(1, Time.valueOf(currentTime));
                            statement.setInt(2, shiftID);
                            statement.setInt(3, employeeid);
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

    @Override
    public ArrayList<Shift> viewAllShiftByEmployeeId(int employeeId) {
        ArrayList<Shift> shiftList = new ArrayList<>();
        try (Connection connection = getConnection()){
            {
                PreparedStatement statement = connection.prepareStatement("SELECT  * FROM shift WHERE employeeid=?");
                statement.setInt(1, employeeId);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int shiftID = resultSet.getInt("shiftid");
                    int employeeID = resultSet.getInt("employeeid");
                    LocalDate date = resultSet.getDate("date").toLocalDate();
                    Time startTime = resultSet.getTime("checkintime");
                    Time endTime = resultSet.getTime("checkouttime");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String startTimeString = startTime.toLocalTime().format(formatter);
                    String endTimeString = endTime.toLocalTime().format(formatter);
                    Shift shifts = new Shift(shiftID, employeeID, date, startTimeString, endTimeString,getEmployeeNameFromEmployeeId(employeeID));
                    shiftList.add(shifts);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return shiftList;
    }
}




