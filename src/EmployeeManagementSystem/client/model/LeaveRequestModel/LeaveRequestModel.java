package EmployeeManagementSystem.client.model.LeaveRequestModel;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LeaveRequestModel
{
    void approveLeave(int shiftID) ;
    void rejectLeave(int shiftID) ;

    void requestLeave(int shiftID,String reason) ;
    ArrayList<LeaveRequest> viewAllLeaveRequests() ;
}
