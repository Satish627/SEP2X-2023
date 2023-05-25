package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.converter.NumberStringConverter;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

public class ViewShiftViewModel {

    private ShiftModel shiftModel;
    private final ObservableList<Shift> shiftObservableList;
    private StringProperty employeeName,checkInTime,checkOutTime;
    private IntegerProperty shiftID,employeeID;
    ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    public ViewShiftViewModel(ShiftModel shiftModel)
    {
        this.shiftModel = shiftModel;
        shiftObservableList= FXCollections.observableList(shiftModel.viewAllShift());
        NumberStringConverter numberStringConverter = new NumberStringConverter();
        initialiseAllProperty();
        shiftModel.addListener("newShiftAdded",this:: newShiftAdded);
        shiftModel.addListener("shiftUpdated",this:: shiftUpdated);
        shiftModel.addListener("shiftRemoved",this:: shiftRemoved);

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
    public ObjectProperty getDate()
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




    public Shift addShift() throws SQLException, RemoteException
    {
        if ((shiftID.get()== 0 || shiftID.toString() == null) && (employeeName.get()==null || employeeName.get().isEmpty()) && (employeeID.get()== 00 || employeeID.toString().isEmpty())  && (date.get()== null || date.toString().isEmpty()) && (checkInTime.get()==null|| checkInTime.get().isEmpty()) && (checkOutTime.get()==null || checkOutTime.get().isEmpty()))
        {
            AlertBox.showAlert ("Please fill in all the information");
        } else if (shiftID.toString() == null||shiftID.get() == 0  ) {
            AlertBox.showAlert ("SHift id cannot be empty or zero");
        } else if (employeeName.get() == null || employeeName.get().isEmpty()) {
            AlertBox.showAlert ("Employee name cannot be empty");
        } else if (employeeID.toString() == null||employeeID.get()==0) {
            AlertBox.showAlert ("Employee ID  cannot be empty or zero");
        }
        else if (date.get() == null || date.toString().isEmpty()) {
            AlertBox.showAlert ("Date cannot be empty");
        } else if (checkInTime.get() == null||checkInTime.get().isEmpty()) {
            AlertBox.showAlert ("CheckIn time cannot be empty");
        }else if ( checkOutTime.toString()==null||checkOutTime.get().isEmpty()) {
            AlertBox.showAlert ("CheckOut time cannot be empty or zero");
        }else {
            try {
                return shiftModel.addShift(shiftID.get(), employeeID.get(), employeeName.get(), date.getValue(), checkInTime.get(), checkOutTime.get());
            } catch (Exception e ) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }


    public void deleteShift(int sId)
    {
        shiftModel.deleteShift(sId);
    }

    public void updateShift(int sId, int eId, String ename, LocalDate datePicker, String checkIn, String checkOut) {
        shiftModel.updateShift(sId,eId,ename,datePicker,checkIn,checkOut);
    }
}
