package EmployeeManagementSystem.client.view.AdminViews.AddShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.*;
import javafx.util.converter.NumberStringConverter;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;


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
        if (shiftID.get()==0||employeeID.get()==0||employeeName.get()==null||date.get()==null||startTime.get()==null||endTime.get()==null)
        {
            System.out.println("Please fill in all the information.");
            return null;
        } else {
            Shift addShift = addShiftModel.addShift(shiftID.get(), employeeID.get(), employeeName.get(), date.get(), startTime.get(), endTime.get());
            return  addShift;
        }

    }
}
