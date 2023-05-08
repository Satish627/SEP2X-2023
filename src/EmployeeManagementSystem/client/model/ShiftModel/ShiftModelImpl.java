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
    public Shift addShift(int shiftID, int employeeID, LocalDate date, int startTime, int endTime) throws SQLException, RemoteException {
        return addShiftClient.addShift(shiftID, employeeID, date, startTime, endTime);
    }

    @Override
    public ArrayList<Shift> viewAllShift() {
        return null;
    }
}
