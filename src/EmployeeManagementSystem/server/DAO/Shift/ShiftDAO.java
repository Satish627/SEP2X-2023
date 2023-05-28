package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ShiftDAO
{
    Shift addShift(int employeeID, LocalDate date, String checkInTime, String checkOutTime) throws RemoteException;

    ArrayList<Shift> viewAllShift() throws SQLException;

    Shift updateShiftInfo(Shift shift) throws RemoteException;
    void deleteShiftById(int shiftID)throws SQLException;

    void checkIn(int shiftID,int userID) throws SQLException;

    void checkOut(int shiftID,int userID) throws SQLException;

    ArrayList<Shift> viewAllShiftByEmployeeId(int employeeId);
}