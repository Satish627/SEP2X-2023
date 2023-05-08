package EmployeeManagementSystem.client.networking.AddShiftClient;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

public interface AddShiftClient
{
    Shift addShift(int shiftID, int employeeID, LocalDate date, int startTime, int endTime) throws RemoteException, SQLException;
}
