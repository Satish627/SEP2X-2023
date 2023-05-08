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
    public Shift addShift(int shiftID, int employeeID, LocalDate date, int startTime, int endTime) throws RemoteException,SQLException {
        return shiftDAO.addShift(shiftID, employeeID, date, startTime, endTime);
    }

  /*  @Override
    public ArrayList<Shift> viewAllShift() {
        return shiftDAO.viewAllShift();

    }*/
}

