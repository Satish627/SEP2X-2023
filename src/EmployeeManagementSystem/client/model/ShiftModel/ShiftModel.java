package EmployeeManagementSystem.client.model.ShiftModel;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ShiftModel
{
    Shift addShift(int shiftID, int employeeID, LocalDate date, int startTime, int endTime) throws SQLException, RemoteException;
    ArrayList<Shift> viewAllShift();

}
