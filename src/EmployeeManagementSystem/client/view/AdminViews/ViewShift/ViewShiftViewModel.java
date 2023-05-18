package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
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
    private ObservableList<Shift> shiftObservableList;
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

    }

    private void newShiftAdded(PropertyChangeEvent propertyChangeEvent)
    {
        Shift newShift = (Shift) propertyChangeEvent.getNewValue();
        shiftObservableList.add(newShift);
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
        return shiftModel.addShift(shiftID.get(), employeeID.get(), employeeName.get(), date.getValue(), checkInTime.get(), checkOutTime.get());


    }



    public void editShift(int shiftId, int employeeId, String employeeName, LocalDate date, String checkInTime, String checkOutTime)
    {

    }

    public void deleteShift(int sId)
    {
        shiftModel.deleteShift(sId);
    }
}
