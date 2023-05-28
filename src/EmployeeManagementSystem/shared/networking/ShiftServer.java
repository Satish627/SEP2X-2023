package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface ShiftServer  extends Remote
{
    Shift addShift(int  employeeID, LocalDate date, String startTIme, String endTime) throws RemoteException;
    ArrayList<Shift> viewAllShift() throws RemoteException, SQLException;
    ArrayList<Shift> viewAllShiftByUserID(int userID) throws RemoteException;
    Shift updateShift(Shift shift) throws RemoteException,SQLException;
    void deleteShiftById(int shiftID) throws RemoteException, SQLException;

    void checkIn(int shiftID, int userID) throws RemoteException,SQLException;
    void checkOut(int shiftID, int userID) throws RemoteException,SQLException;
}
