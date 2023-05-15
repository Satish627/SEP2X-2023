package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.model.Users;
import javafx.fxml.FXML;

import static EmployeeManagementSystem.server.DataBaseConnection.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static EmployeeManagementSystem.server.DataBaseConnection.getConnection;

public class ShiftDAOImpl implements ShiftDAO {

 @FXML
    public Shift addShift(int shiftID, int employeeID,String employeeName, LocalDate date, String startTime, String endTime)  {
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
            return new Shift(shiftID, employeeID, date, startTime, endTime);
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
 }


   /* @Override
    public ArrayList<Shift> viewAllShift() {
        return null;
    }*/
}

