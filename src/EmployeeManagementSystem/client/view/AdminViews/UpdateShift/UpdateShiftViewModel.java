package EmployeeManagementSystem.client.view.AdminViews.UpdateShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.*;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;


public class UpdateShiftViewModel {
    private ShiftModel shiftModel;
    private StringProperty startTime, endTime;
    private ObjectProperty<LocalDate> shiftDate;

    public UpdateShiftViewModel(ShiftModel shiftModel) {
        this.shiftModel = shiftModel;
        initialiseAllProperty();
    }

    private void initialiseAllProperty() {
        shiftDate = new SimpleObjectProperty<>();
        startTime = new SimpleStringProperty();
        endTime = new SimpleStringProperty();

        Shift selectedShift = shiftModel.getSelectedShift();
        shiftDate.set(selectedShift.getDate());
        startTime.set(selectedShift.getCheckInTime());
        endTime.set(selectedShift.getCheckOutTime());
    }

    public ObjectProperty<LocalDate> getShiftDate() {
        return shiftDate;
    }

    public StringProperty getStartTime() {
        return startTime;
    }

    public StringProperty getEndTime() {
        return endTime;
    }


    public void updateShift()
    {
        Shift copy = shiftModel.getSelectedShift().copy();
        if (!startTime.get().isEmpty()){
            copy.setCheckInTime(startTime.getValue());
        }
        if (!endTime.get().isEmpty()){
            copy.setCheckOutTime(endTime.getValue());
        }
        if (shiftDate.get() != null){
            copy.setDate(shiftDate.getValue());
        }
        System.out.println(copy);
        shiftModel.updateShift(copy);
    }
}