package EmployeeManagementSystem.client.view.AdminViews.AddShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.*;
import javafx.util.converter.NumberStringConverter;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.SimpleTimeZone;

public class AddShiftViewModel {
    private ShiftModel addShiftModel;
    private IntegerProperty shiftID, employeeID;
    private StringProperty startTime, endTime;
    private StringProperty employeeName;
    private ObjectProperty<LocalDate> date;
    private final NumberStringConverter numberStringConverter;

    public AddShiftViewModel(ShiftModel addNewShiftModel) {
        this.addShiftModel = addNewShiftModel;
        this.numberStringConverter = new NumberStringConverter();
        initialiseAllProperty();
    }

    private void initialiseAllProperty() {
        shiftID = new SimpleIntegerProperty();
        employeeID = new SimpleIntegerProperty();
        employeeName = new SimpleStringProperty();
        date = new SimpleObjectProperty<>();
        startTime = new SimpleStringProperty();
        endTime = new SimpleStringProperty();
    }

    public IntegerProperty getShiftID() {
        return shiftID;
    }

    public IntegerProperty getEmployeeID() {
        return employeeID;
    }

    public ObjectProperty<LocalDate> getDate() {
        return date;
    }

    public StringProperty getStartTime() {
        return startTime;
    }

    public StringProperty getEndTime() {
        return endTime;
    }

    public StringProperty getEmployeeName() {
        return employeeName;
    }

    public Shift addShift() throws SQLException, RemoteException
    {
        Shift addShift = addShiftModel.addShift(shiftID.get(), employeeID.get(), employeeName.get(), date.get(), startTime.get(), endTime.get());
        return  addShift;

    }

//    public Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime)
//    {
//        if(shiftID == 0 || employeeID==0 || employeeName==null || employeeName.isEmpty()|| date == null || startTime== null ||startTime.isEmpty() || endTime == null || endTime.isEmpty())
//        {
//           return null;
//        }
//        return addShift(shiftID, employeeID, employeeName, date, startTime, endTime);
//    }


}
