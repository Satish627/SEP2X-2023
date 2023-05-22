package EmployeeManagementSystem.client.view.EmployeeViews.EmployeeLeaveRequestPage;

import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModel;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class EmployeeLeaveRequestViewModel {
    private LeaveRequestModel leaveRequestModel;
    private IntegerProperty shiftID;
    private StringProperty reason;
    public EmployeeLeaveRequestViewModel(LeaveRequestModelImpl leaveRequestModel)
    {
        this.leaveRequestModel=leaveRequestModel;
        initializeAllProperty();
    }

    private void initializeAllProperty()
    {
        shiftID=new SimpleIntegerProperty();
        reason=new SimpleStringProperty();
    }


    public IntegerProperty getShiftID() {
        return shiftID;
    }

    public StringProperty getReason() {
        return reason;
    }

    public void requestLeave() throws SQLException,RemoteException {
        if(shiftID.get()==0||reason.get()==null||reason.get().isEmpty()){
            System.out.println("Please fill in all information");
        }
        else
        {
            leaveRequestModel.requestLeave(shiftID.get(),reason.get());
        }
    }
}
