package EmployeeManagementSystem.client.networking.LeaveRequestClient;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

import java.util.ArrayList;

public interface LeaveRequestClient
{
    void approveLeave(int shiftID);
    void rejectLeave(int shiftID);
    ArrayList<LeaveRequest> viewAllLeaveRequests();
}
