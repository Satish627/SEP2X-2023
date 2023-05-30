package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class ViewShiftViewModel {

    private ShiftModel shiftModel;
    private final ObservableList<Shift> shiftObservableList;
    private StringProperty employeeName,checkInTime,checkOutTime;
    private IntegerProperty shiftID,employeeID;
    ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    public ViewShiftViewModel(ShiftModel shiftModel)
    {
        this.shiftModel = shiftModel;
        shiftObservableList= FXCollections.observableArrayList();
        initialiseAllProperty();
        shiftModel.addListener("newShiftAdded",this:: newShiftAdded);
        shiftModel.addListener("shiftUpdated",this:: shiftUpdated);
        shiftModel.addListener("shiftRemoved",this:: shiftRemoved);

    }

    public ArrayList<Shift> fetchAllShifts(){
        return shiftModel.viewAllShift();
    }

    private void shiftUpdated(PropertyChangeEvent propertyChangeEvent) {
        Shift newShift = (Shift) propertyChangeEvent.getNewValue();
        shiftObservableList.addAll(newShift);
        shiftObservableList.setAll(shiftModel.viewAllShift());
    }

    private void shiftRemoved(PropertyChangeEvent propertyChangeEvent) {
        shiftObservableList.remove((Shift) propertyChangeEvent.getNewValue());
        shiftObservableList.setAll(shiftModel.viewAllShift());
    }

    void newShiftAdded(PropertyChangeEvent propertyChangeEvent)
    {
        Shift newShift = (Shift) propertyChangeEvent.getNewValue();
        shiftObservableList.add(newShift);
        shiftObservableList.setAll(shiftModel.viewAllShift());
    }

    private void initialiseAllProperty() {
        shiftID = new SimpleIntegerProperty();
        employeeID = new SimpleIntegerProperty();
        employeeName= new SimpleStringProperty();
        date = new SimpleObjectProperty<>();
        checkInTime = new SimpleStringProperty();
        checkOutTime = new SimpleStringProperty();
        shiftObservableList.setAll(fetchAllShifts());

    }
    public IntegerProperty getShiftID()
    {
        return shiftID;
    }
    public IntegerProperty getEmployeeID()
    {
        return employeeID;
    }
    public StringProperty getEmployeeName()
    {
        return employeeName;
    }
    public ObjectProperty<LocalDate> getDate()
    {
        return date;
    }
    public StringProperty getCheckInTime()
    {
        return checkInTime;
    }
    public StringProperty getCheckOutTime()
    {
        return checkOutTime;
    }

    public ObservableList<Shift> viewAllShift()
    {
        return shiftObservableList;
    }

    public void deleteShift(int sId)
    {
        shiftModel.deleteShift(sId);
    }

    public void updateShift(Shift shift) {
        shiftModel.setSelectedShift(shift);
    }
}
