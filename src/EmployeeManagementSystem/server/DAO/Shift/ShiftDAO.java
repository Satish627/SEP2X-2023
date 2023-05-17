package EmployeeManagementSystem.server.DAO.Shift;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ShiftDAO
{
    Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) throws RemoteException, SQLException;

    ArrayList<Shift> viewAllShift() throws SQLException;
    void deleteShiftById(int shiftID)throws SQLException;
    void updateShiftInfo(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) throws SQLException;
}
