package EmployeeManagementSystem.client.model.ShiftModel;

import EmployeeManagementSystem.client.networking.ShiftClient.ShiftClient;
import EmployeeManagementSystem.shared.model.Shift;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShiftModelImpl implements ShiftModel
{
    private ShiftClient shiftClient;
    private PropertyChangeSupport propertyChangeSupport;
    private Shift selectedShift;

    public ShiftModelImpl(ShiftClient shiftClient)

    {
        this.shiftClient = shiftClient;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        shiftClient.addListener("newShiftAdded",this:: newShiftAdded);
        shiftClient.addListener("shiftRemoved", this:: shiftRemoved);
        shiftClient.addListener("shiftUpdated", this:: shiftUpdated);
        shiftClient.addListener("checkIn",this::checkIn);
        shiftClient.addListener("checkOut",this::checkOut);
    }

    private void checkOut(PropertyChangeEvent event)
    {
        propertyChangeSupport.firePropertyChange(event);
        System.out.println("Shift has been checked in from Shift Model");
    }

    private void checkIn(PropertyChangeEvent event)
    {
        propertyChangeSupport.firePropertyChange(event);
        System.out.println("Shift has been checked out from Shift Model");
    }

    private void shiftUpdated(PropertyChangeEvent propertyChangeEvent) {
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
        System.out.println("Shift has been updated from Shift Model");

    }

    private void shiftRemoved(PropertyChangeEvent propertyChangeEvent)
    {
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
        System.out.println("Shift has been removed from Shift Model");
    }

    private void newShiftAdded(PropertyChangeEvent propertyChangeEvent)
    {
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
    }

    @Override
    public Shift addShift( int employeeID, LocalDate date, String startTime, String endTime)
    {
        try {
            return shiftClient.addShift(employeeID,date, startTime, endTime);
        } catch (RemoteException e)  {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<Shift> viewAllShift() {
        return shiftClient.viewAllShift();
    }

    @Override
    public ArrayList<Shift> viewAllShiftByUserID(int userID) {
        return shiftClient.viewAllShiftByUserID(userID);
    }

    @Override
    public void deleteShift(int sId)
    {
        shiftClient.deleteShift(sId);

    }

    @Override
    public void checkIn(int shiftID, int userID) {
        shiftClient.checkIn(shiftID,userID);
    }

    @Override
    public void checkOut(int shiftID, int userID) {
        shiftClient.checkOut(shiftID,userID);
    }

    @Override
    public void updateShift(Shift shift) {
        try {
            shiftClient.updateShift(shift);
        } catch (RemoteException  e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Shift getSelectedShift() {
        return this.selectedShift;
    }

    @Override
    public void setSelectedShift(Shift shift) {
        this.selectedShift = shift;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(eventName,listener);

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener)
    {
        propertyChangeSupport.removePropertyChangeListener(eventName,listener);

    }

}
