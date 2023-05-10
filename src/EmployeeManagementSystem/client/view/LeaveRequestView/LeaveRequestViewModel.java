package EmployeeManagementSystem.client.view.LeaveRequestView;

import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModel;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LeaveRequestViewModel
{
    private LeaveRequestModel leaveRequestModel;
    private StringProperty shiftID,reason;
    public LeaveRequestViewModel(LeaveRequestModelImpl leaveRequestModel)
    {
        this.leaveRequestModel=leaveRequestModel;
        initialiseAllProperty();
    }

    private void initialiseAllProperty(){
        shiftID=new SimpleStringProperty();
        reason=new SimpleStringProperty();
    }



    public StringProperty getShiftID() {
        return shiftID;
    }

    public StringProperty getReason() {
        return reason;
    }

    public LeaveRequest approveLeave(){
        if(shiftID.get()==null||reason.get()==null){
            System.out.println("Null value");
            return null;
        }
        else
        {
            return leaveRequestModel.approveLeave(Integer.parseInt(shiftID.get()),reason.get());
        }
    }
}
