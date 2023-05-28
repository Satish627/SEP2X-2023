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
        shiftObservableList= FXCollections.observableList(fetchAllShifts());
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

    private void newShiftAdded(PropertyChangeEvent propertyChangeEvent)
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

    public Shift addShift()
    {
        if ((shiftID.get()== 0 || shiftID.toString() == null) && (employeeName.get()==null || employeeName.get().isEmpty()) && (employeeID.get()== 00 || employeeID.toString().isEmpty())  && (date.get()== null || date.toString().isEmpty()) && (checkInTime.get()==null|| checkInTime.get().isEmpty()) && (checkOutTime.get()==null || checkOutTime.get().isEmpty()))
        {
            throw new RuntimeException ("Please fill in all the information");
        } else if (shiftID.toString() == null||shiftID.get() == 0  ) {
            throw new RuntimeException ("SHift id cannot be empty or zero");
        } else if (employeeName.get() == null || employeeName.get().isEmpty()) {
            throw new RuntimeException ("Employee name cannot be empty");
        } else if (employeeID.toString() == null||employeeID.get()==0) {
            throw new RuntimeException ("Employee ID  cannot be empty or zero");
        }
        else if (date.get() == null || date.toString().isEmpty()) {
            throw new RuntimeException ("Date cannot be empty");
        } else if (checkInTime.get() == null||checkInTime.get().isEmpty()) {
            throw new RuntimeException ("CheckIn time cannot be empty");
        }else if ( checkOutTime.toString()==null||checkOutTime.get().isEmpty()) {
            throw new RuntimeException ("CheckOut time cannot be empty or zero");
        }else {
                return shiftModel.addShift(shiftID.get(), employeeID.get(), employeeName.get(), date.getValue(), checkInTime.get(), checkOutTime.get());
        }
    }


    public void deleteShift(int sId)
    {
        shiftModel.deleteShift(sId);
    }

    public void updateShift(int sId, int eId, String ename, LocalDate datePicker, String checkIn, String checkOut) {
        shiftModel.updateShift(sId,eId,ename,datePicker,checkIn,checkOut);
    }
}
