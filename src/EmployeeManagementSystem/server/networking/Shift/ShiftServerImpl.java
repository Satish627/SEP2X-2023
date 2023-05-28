package EmployeeManagementSystem.server.networking.Shift;

import EmployeeManagementSystem.server.DAO.Shift.ShiftDAO;
import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.networking.ShiftServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShiftServerImpl implements ShiftServer {
    private ShiftDAO shiftDAO;

    public ShiftServerImpl(ShiftDAO shiftDAO) throws RemoteException {
        this.shiftDAO = shiftDAO;
        UnicastRemoteObject.exportObject(this, 0);


    }

    @Override
    public Shift addShift( int employeeID, LocalDate date, String checkInTime, String checkOutTime) throws RemoteException
    {
        return shiftDAO.addShift( employeeID, date, checkInTime, checkOutTime);
    }

    @Override
    public ArrayList<Shift> viewAllShift() throws RemoteException, SQLException
    {
        return shiftDAO.viewAllShift();
    }

    @Override
    public ArrayList<Shift> viewAllShiftByUserID(int userID) throws RemoteException {
        return shiftDAO.viewAllShiftByEmployeeId(userID);
    }

    @Override
    public Shift updateShift(Shift shift) throws RemoteException, SQLException {
        return shiftDAO.updateShiftInfo(shift);
    }

    @Override
    public void deleteShiftById(int shiftID) throws RemoteException, SQLException {
        shiftDAO.deleteShiftById(shiftID);

    }

    @Override
    public void checkIn(int shiftID, int userID) throws RemoteException, SQLException {
        shiftDAO.checkIn(shiftID,userID);
    }

    @Override
    public void checkOut(int shiftID, int userID) throws RemoteException, SQLException {
        shiftDAO.checkOut(shiftID,userID);
    }
}

