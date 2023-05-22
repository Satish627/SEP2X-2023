package EmployeeManagementSystem.shared.networking;


import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LeaveRequestServer extends Remote
{
    void approveLeave(int shiftID) throws RemoteException, SQLException;
    void rejectLeave(int shiftID) throws RemoteException, SQLException;

    void requestLeave(int shiftID,String reason) throws RemoteException,SQLException;

    ArrayList<LeaveRequest> viewAllLeaveRequests() throws RemoteException, SQLException;
}
