package EmployeeManagementSystem.client.networking.LeaveRequestClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.networking.LeaveRequestServer;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;

public class LeaveRequestClientImpl implements LeaveRequestClient
{
    private Server server;

    public LeaveRequestClientImpl() {
        try {
            System.out.println("hello babies and welcome to leave request");
            server= GetServer.getRMIServer();
        }
        catch (Exception e){
            throw e;
        }
    }


    public LeaveRequest approveLeave(int shiftID, String reason) {
        try {
            return server.getLeaveRequestServer().approveLeave(shiftID,reason);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
