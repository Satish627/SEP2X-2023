package EmployeeManagementSystem.client.model.LeaveRequestModel;

import EmployeeManagementSystem.client.networking.LeaveRequestClient.LeaveRequestClient;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

public class LeaveRequestModelImpl implements LeaveRequestModel{
    private LeaveRequestClient leaveRequestClient;
    public LeaveRequestModelImpl(LeaveRequestClient leaveRequestClient)
    {
        this.leaveRequestClient=leaveRequestClient;
    }

    @Override
    public LeaveRequest approveLeave(int shiftID, String reason) {
        return leaveRequestClient.approveLeave(shiftID,reason);
    }
}
