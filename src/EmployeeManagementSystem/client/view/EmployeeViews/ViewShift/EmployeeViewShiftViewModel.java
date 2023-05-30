package EmployeeManagementSystem.client.view.EmployeeViews.ViewShift;

import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.util.List;

public class EmployeeViewShiftViewModel
{
    private ShiftModel shiftModel;
    private List<Shift> allShifts;
    private ObservableList<Shift> shiftsToShow;
    private StringProperty totalHours;
    private LoginModel loginModel;

    private int userID;

    public EmployeeViewShiftViewModel(ShiftModel shiftModel, LoginModel loginModel) {
        this.shiftModel = shiftModel;
        this.loginModel = loginModel;
        allShifts = shiftModel.viewAllShiftByUserID(loginModel.getCurrentUserId());
        totalHours = new SimpleStringProperty();
        this.shiftsToShow = FXCollections.observableArrayList(allShifts);
        calculateTotalHours();
        shiftModel.addListener("newShiftAdded",this::newShiftAdded);
        shiftModel.addListener("checkIn",this::checkIn);
        shiftModel.addListener("checkOut",this::checkOut);

    }

    private void checkOut(PropertyChangeEvent event)
    {
        Shift newShift= (Shift) event.getNewValue();
        shiftsToShow.add(newShift);
        shiftsToShow.setAll(shiftModel.viewAllShiftByUserID(loginModel.getCurrentUserId()));

    }

    private void checkIn(PropertyChangeEvent event)
    {
        Shift newShift= (Shift) event.getNewValue();
        shiftsToShow.add(newShift);
        shiftsToShow.setAll(shiftModel.viewAllShiftByUserID(loginModel.getCurrentUserId()));
    }

    public ObservableList<Shift> getShiftsToShow()
    {
        return shiftsToShow;
    }

    private void newShiftAdded(PropertyChangeEvent propertyChangeEvent) {
        Shift newShift = (Shift) propertyChangeEvent.getNewValue();
        shiftsToShow.add(newShift);
       shiftsToShow.setAll(shiftModel.viewAllShiftByUserID(userID));
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void checkIn(int shiftID,int userId)
    {
        shiftModel.checkIn(shiftID,userId);
    }
    public void checkOut(int shiftID,int userId)
    {
        shiftModel.checkOut(shiftID,userId);
    }

    public void allSelected() {
        shiftsToShow.setAll(allShifts);
        calculateTotalHours();
    }

    public void upcomingSelected() {
        List<Shift> upcomingShifts = allShifts.stream().filter(shift -> !shift.getDate().isBefore(LocalDate.now())).toList();
        shiftsToShow.setAll(upcomingShifts);
        calculateTotalHours();

    }

    public void pastSelected() {
        List<Shift> pastShifts = allShifts.stream().filter(shift -> shift.getDate().isBefore(LocalDate.now())).toList();
        shiftsToShow.setAll(pastShifts);
        calculateTotalHours();


    }

    public void calculateTotalHours() {
        int totalHoursInt = shiftsToShow.stream().mapToInt(Shift::getTotalHours).sum();
        totalHours.setValue(String.valueOf(totalHoursInt));
    }

    public StringProperty getTotalHours() {
        return totalHours;
    }
}
