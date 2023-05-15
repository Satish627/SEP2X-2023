package EmployeeManagementSystem.client.model.ShiftModel;

import EmployeeManagementSystem.client.networking.AddShiftClient.AddShiftClient;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShiftModelImpl implements ShiftModel
{
    private AddShiftClient addShiftClient;
    public ShiftModelImpl(AddShiftClient addShiftClient)
    {
        this.addShiftClient = addShiftClient;
    }

    @Override
    public Shift addShift(int shiftID, int employeeID, String employeeName,LocalDate date, String startTime, String endTime)  {
        return addShiftClient.addShift(shiftID, employeeID, employeeName,date, startTime, endTime);
    }

    @Override
    public ArrayList<Shift> viewAllShift() {
        return null;
    }
}
