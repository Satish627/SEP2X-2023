package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.model.Users;
import javafx.fxml.FXML;

import static EmployeeManagementSystem.server.DataBaseConnection.getConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static EmployeeManagementSystem.server.DataBaseConnection.getConnection;

public class ShiftDAOImpl implements ShiftDAO {

 @FXML
    public Shift addShift(int shiftID, int employeeID, LocalDate date, int startTime, int endTime) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement newStatement = connection.prepareStatement("INSERT INTO shift (shiftID, employeeID, date, startTime, endTime) VALUES (?, ?, ?, ?, ?);");
            newStatement.setInt(1, shiftID);
            newStatement.setInt(2, employeeID);
            newStatement.setDate(3, Date.valueOf(date));
            newStatement.setInt(4, startTime);
            newStatement.setInt(5, endTime);

            newStatement.executeUpdate();
            connection.close();
            System.out.println("Shift added successfully");
            return new Shift(shiftID, employeeID, date, startTime, endTime);
        }
    }


   /* @Override
    public ArrayList<Shift> viewAllShift() {
        return null;
    }*/
}

