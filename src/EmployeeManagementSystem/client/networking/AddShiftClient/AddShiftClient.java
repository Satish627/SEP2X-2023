package EmployeeManagementSystem.client.networking.AddShiftClient;

import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

public interface AddShiftClient
{
    Shift addShift(int shiftID, int employeeID,String employeeName,LocalDate date, String startTime, String endTime) ;
}
