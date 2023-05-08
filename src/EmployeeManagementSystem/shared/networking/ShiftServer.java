package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface ShiftServer  extends Remote
{
    Shift addShift(int shiftID, int employeeID, LocalDate date, int startTIme,int endTime) throws RemoteException, SQLException;
    //ArrayList<Shift> viewAllShift();
}
