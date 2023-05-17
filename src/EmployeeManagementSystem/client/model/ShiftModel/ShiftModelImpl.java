package EmployeeManagementSystem.client.model.ShiftModel;

import EmployeeManagementSystem.client.networking.ShiftClient.ShiftClient;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
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
    public Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime) throws SQLException, RemoteException {
        return shiftClient.addShift(shiftID, employeeID, employeeName,date, startTime, endTime);
    }

    @Override
    public ArrayList<Shift> viewAllShift() {
        return shiftClient.viewAllShift();
    }

//    @Override
//    public void updateShift(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) {
//        shiftClient.updateShiftInfo(shiftID,employeeID,employeeName,date,checkInTime,checkOutTime);
//    }
}
