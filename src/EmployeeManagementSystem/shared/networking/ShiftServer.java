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
    Shift addShift(int shiftID, int  employeeID, String employeeName, LocalDate date, String startTIme, String endTime) throws RemoteException, SQLException;
    ArrayList<Shift> viewAllShift() throws RemoteException, SQLException;

}
