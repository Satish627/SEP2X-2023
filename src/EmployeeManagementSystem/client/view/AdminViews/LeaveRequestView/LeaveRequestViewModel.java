package EmployeeManagementSystem.client.view.AdminViews.LeaveRequestView;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModel;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class LeaveRequestViewModel
{
    private LeaveRequestModel leaveRequestModel;
    private ObservableList<LeaveRequest> leaveRequests;


    public LeaveRequestViewModel(LeaveRequestModel leaveRequestModel) {
        this.leaveRequestModel = leaveRequestModel;

        List<LeaveRequest> requestList = null;
        requestList = leaveRequestModel.viewAllLeaveRequests();
        if (requestList != null) {
            leaveRequests = FXCollections.observableList(requestList);
        } else {
            leaveRequests = FXCollections.observableArrayList();
        }
    }



    public void approveLeave(int shiftID) {
        if (shiftID==0) {
            System.out.println("ShiftID is null");
        } else {
            leaveRequestModel.approveLeave(shiftID);
        }
    }

    public void rejectLeave(int shiftID)  {
        if (shiftID==0) {
            System.out.println("ShiftID is null");
        } else {
            leaveRequestModel.rejectLeave(shiftID);
        }
    }

    public ObservableList<LeaveRequest> viewAllLeaveRequests(){
        return leaveRequests;
    }

}
