package EmployeeManagementSystem.shared.networking;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LeaveRequestServer extends Remote
{
    LeaveRequest approveLeave(int shiftID,String reason) throws RemoteException;
}
