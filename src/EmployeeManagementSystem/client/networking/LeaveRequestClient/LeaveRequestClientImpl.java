package EmployeeManagementSystem.client.networking.LeaveRequestClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeaveRequestClientImpl implements LeaveRequestClient
{
    private Server server;

    public LeaveRequestClientImpl() {
        try {
            System.out.println("hello babies and welcome to leave request");
            server= GetServer.getRMIServer();
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }


    public void approveLeave(int shiftID) {
        try {
            server.getLeaveRequestServer().approveLeave(shiftID);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rejectLeave(int shiftID) {
        try {
            server.getLeaveRequestServer().rejectLeave(shiftID);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void requestLeave(int shiftID,String reason){
        try {
            server.getLeaveRequestServer().requestLeave(shiftID,reason);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<LeaveRequest> viewAllLeaveRequests() {
        try {
             return server.getLeaveRequestServer().viewAllLeaveRequests();
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
