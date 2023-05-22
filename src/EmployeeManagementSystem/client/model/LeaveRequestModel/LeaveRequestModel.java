package EmployeeManagementSystem.client.model.LeaveRequestModel;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LeaveRequestModel
{
    void approveLeave(int shiftID) throws RemoteException;
    void rejectLeave(int shiftID) throws RemoteException;

    void requestLeave(int shiftID,String reason) throws RemoteException;
    ArrayList<LeaveRequest> viewAllLeaveRequests() throws RemoteException;
}
