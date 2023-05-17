package EmployeeManagementSystem.server.networking.Shift;

import EmployeeManagementSystem.server.DAO.Shift.ShiftDAO;
import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.networking.ShiftServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShiftServerImpl implements ShiftServer {
    private ShiftDAO shiftDAO;

    public ShiftServerImpl(ShiftDAO shiftDAO) throws RemoteException {
        this.shiftDAO = shiftDAO;
        UnicastRemoteObject.exportObject(this, 0);


    }

    @Override
    public Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) throws RemoteException,SQLException
    {
        return shiftDAO.addShift(shiftID, employeeID, employeeName, date, checkInTime, checkOutTime);
    }

    @Override
    public ArrayList<Shift> viewAllShift() throws RemoteException, SQLException
    {
        return shiftDAO.viewAllShift();
    }

    @Override
    public void deleteShiftById(int shiftID) throws RemoteException, SQLException {
        shiftDAO.deleteShiftById(shiftID);

    }


}

