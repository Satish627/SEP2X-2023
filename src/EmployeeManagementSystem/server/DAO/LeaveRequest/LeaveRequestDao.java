package EmployeeManagementSystem.server.DAO.LeaveRequest;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

public interface LeaveRequestDao
{
    LeaveRequest approveLeave(int shiftID,String reason);
    LeaveRequest rejectLeave();
}
