package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ShiftDAO
{
    Shift addShift(int shiftID, int employeeID, LocalDate date, int startTime, int endTime) throws RemoteException, SQLException;
   // ArrayList<Shift> viewAllShift();

}
