package EmployeeManagementSystem.client.view.EmployeeViews.ViewShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        return shiftObservableList;
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
