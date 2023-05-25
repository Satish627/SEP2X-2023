package EmployeeManagementSystem.client.view.EmployeeViews.ViewShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;

public class EmployeeViewShiftViewModel
{
    private ShiftModel shiftModel;
    private ObservableList<Shift> shiftObservableList;

    private int userID;

    public EmployeeViewShiftViewModel(ShiftModel shiftModel) {
        this.shiftModel = shiftModel;
        this.shiftObservableList = FXCollections.observableArrayList();
    }

    public ObservableList<Shift> viewAllShiftsByUserID(int uID){
        shiftObservableList.clear();
        shiftObservableList.addAll(shiftModel.viewAllShiftByUserID(uID));
        shiftModel.addListener("newShiftAdded",this::newShiftAdded);
        return shiftObservableList;
    }

    private void newShiftAdded(PropertyChangeEvent propertyChangeEvent) {
        Shift newShift = (Shift) propertyChangeEvent.getNewValue();
        shiftObservableList.add(newShift);
       shiftObservableList.setAll(shiftModel.viewAllShiftByUserID(userID));
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void checkIn(int shiftID,int password)
    {
        shiftModel.checkIn(shiftID,password);
    }
    public void checkOut(int shiftID,int password)
    {
        shiftModel.checkOut(shiftID,password);
    }
}
