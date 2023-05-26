package EmployeeManagementSystem.client.model.LeaveRequestModel;
import EmployeeManagementSystem.client.networking.LeaveRequestClient.LeaveRequestClient;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import java.util.ArrayList;

public class LeaveRequestModelImpl implements LeaveRequestModel{
    private LeaveRequestClient leaveRequestClient;
    public LeaveRequestModelImpl(LeaveRequestClient leaveRequestClient)

    {
        this.leaveRequestClient=leaveRequestClient;
    }


    @Override
    public void approveLeave(int shiftID) {
        leaveRequestClient.approveLeave(shiftID);
    }

    @Override
    public void rejectLeave(int shiftID) {
        leaveRequestClient.rejectLeave(shiftID);
    }

    @Override
    public void requestLeave(int shiftID, String reason) {
        leaveRequestClient.requestLeave(shiftID,reason);
    }

    @Override
    public ArrayList<LeaveRequest> viewAllLeaveRequests()  {
        return leaveRequestClient.viewAllLeaveRequests();
    }
}
