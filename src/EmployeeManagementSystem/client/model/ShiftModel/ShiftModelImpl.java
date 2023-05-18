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
    public ShiftModelImpl(ShiftClient shiftClient)

    {
        this.shiftClient = shiftClient;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        shiftClient.addListener("newShiftAdded",this:: newShiftAdded);
    }

    private void newShiftAdded(PropertyChangeEvent propertyChangeEvent)
    {
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
        System.out.println("Shift added from ShiftModelImpl.");
    }

    @Override
    public Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime) throws SQLException, RemoteException {
        return shiftClient.addShift(shiftID, employeeID, employeeName,date, startTime, endTime);
    }

    @Override
    public ArrayList<Shift> viewAllShift() {
        return shiftClient.viewAllShift();
    }

    @Override
    public void deleteShift(int sId)
    {
        shiftClient.deleteShift(sId);

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

//    @Override
//    public void updateShift(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) {
//        shiftClient.updateShiftInfo(shiftID,employeeID,employeeName,date,checkInTime,checkOutTime);
//    }
}
