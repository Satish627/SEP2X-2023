package EmployeeManagementSystem.client.networking.ShiftClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.networking.Server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ShiftClientImpl implements ShiftClient {
    private Server server;
    private PropertyChangeSupport propertyChangeSupport;


    public ShiftClientImpl() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        try {
            System.out.println("Hello from  addShift client networking!!");
            server = GetServer.getRMIServer();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Shift addShift(int employeeID, LocalDate date, String startTime, String endTime) {
        try {

            Shift shift = server.getShiftServer().addShift(employeeID, date, startTime, endTime);
            propertyChangeSupport.firePropertyChange("newShiftAdded", null, shift);
            return shift;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Shift> viewAllShift() {

        try {
            return server.getShiftServer().viewAllShift();
        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        }
        return null; // Return null in case of exceptions
    }


    @Override
    public void updateShift(Shift shift) {

        try {
            Shift shift1 = server.getShiftServer().updateShift(shift);
            propertyChangeSupport.firePropertyChange("shiftUpdated", null, shift1);
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteShift(int sId) {
        try {
            server.getShiftServer().deleteShiftById(sId);
            propertyChangeSupport.firePropertyChange("shiftRemoved", null, new Shift(sId));
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<Shift> viewAllShiftByUserID(int userID) {
        try {
            return server.getShiftServer().viewAllShiftByUserID(userID);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void checkIn(int shiftID, int userID) {
        try {
            server.getShiftServer().checkIn(shiftID, userID);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void checkOut(int shiftID, int userID) {
        try {
            server.getShiftServer().checkOut(shiftID, userID);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(eventName, listener);

    }

}


