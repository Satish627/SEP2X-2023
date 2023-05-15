package EmployeeManagementSystem.client.model.ShiftModel;

import EmployeeManagementSystem.client.networking.ShiftClient.ShiftClient;
import EmployeeManagementSystem.shared.model.Shift;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShiftModelImpl implements ShiftModel
{
    private ShiftClient shiftClient;
    public ShiftModelImpl(ShiftClient shiftClient)
    {
        this.shiftClient = shiftClient;
    }

    @Override
    public Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime)  {
        return shiftClient.addShift(shiftID, employeeID, employeeName,date, startTime, endTime);
    }

    @Override
    public ArrayList<Shift> viewAllShift() {
        return null;
    }
}
