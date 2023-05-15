package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ShiftDAO
{
    Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime) throws RemoteException, SQLException;
   // ArrayList<Shift> viewAllShift();

}
