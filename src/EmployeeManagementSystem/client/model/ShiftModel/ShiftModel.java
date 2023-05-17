package EmployeeManagementSystem.client.model.ShiftModel;

import EmployeeManagementSystem.shared.Subject;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ShiftModel extends Subject
{

    Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime) throws SQLException, RemoteException;

    ArrayList<Shift> viewAllShift();

    void deleteShift(int eId);

//    void updateShift(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime);
}
