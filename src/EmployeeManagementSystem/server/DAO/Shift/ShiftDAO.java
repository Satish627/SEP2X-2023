package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface ShiftDAO
{
    Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) throws RemoteException, SQLException;

    ArrayList<Shift> viewAllShift() throws SQLException;
    ArrayList<Shift> viewAllShiftByUserID(int userID);

    void deleteShiftById(int shiftID)throws SQLException;

    void checkIn(int shiftID,int userID) throws SQLException;

    void checkOut(int shiftID,int userID) throws SQLException;
}