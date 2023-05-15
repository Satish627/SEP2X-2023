package EmployeeManagementSystem.client.networking.ShiftClient;

import EmployeeManagementSystem.shared.model.Shift;

import java.time.LocalDate;

public interface ShiftClient
{
    Shift addShift(int shiftID, int employeeID,String employeeName,LocalDate date, String startTime, String endTime) ;
}
