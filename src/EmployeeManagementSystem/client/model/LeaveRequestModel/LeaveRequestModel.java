package EmployeeManagementSystem.client.model.LeaveRequestModel;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

public interface LeaveRequestModel
{
    LeaveRequest approveLeave(int shiftID,String reason);
}
