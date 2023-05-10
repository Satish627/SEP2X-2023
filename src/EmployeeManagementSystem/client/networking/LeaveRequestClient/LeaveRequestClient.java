package EmployeeManagementSystem.client.networking.LeaveRequestClient;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

public interface LeaveRequestClient
{
    LeaveRequest approveLeave(int shiftID,String reason);
}
