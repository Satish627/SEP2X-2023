package EmployeeManagementSystem.client.view.AdminViews.AddShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.*;
import java.time.LocalDate;


public class AddShiftViewModel {
    private ShiftModel addShiftModel;
    private IntegerProperty shiftID, employeeID;
    private StringProperty startTime, endTime;
    private StringProperty employeeName;
    private ObjectProperty<LocalDate> date;


    public AddShiftViewModel(ShiftModel addNewShiftModel) {
        this.addShiftModel = addNewShiftModel;
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

    public Shift addShift()
    {
        if (employeeID.get()==0||date.get()==null||startTime.get()==null||endTime.get()==null)
        {
            System.out.println("Please fill in all the information.");
            return null;
        } else {
            Shift addShift = addShiftModel.addShift(employeeID.get(), date.get(), startTime.get(), endTime.get());
            return  addShift;
        }

    }
}
