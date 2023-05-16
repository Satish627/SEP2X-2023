package EmployeeManagementSystem.server.networking.LeaveRequest;

import EmployeeManagementSystem.server.DAO.LeaveRequest.LeaveRequestDao;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.networking.LeaveRequestServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;


public class LeaveRequestServerImpl implements LeaveRequestServer
{

    private LeaveRequestDao leaveRequestDao;

    public LeaveRequestServerImpl(LeaveRequestDao leaveRequestDao) throws RemoteException{
        this.leaveRequestDao=leaveRequestDao;
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public void approveLeave(int shiftID) throws RemoteException, SQLException {
        leaveRequestDao.approveLeave(shiftID);
    }

    @Override
    public void rejectLeave(int shiftID) throws RemoteException, SQLException {
        leaveRequestDao.rejectLeave(shiftID);
    }

    @Override
    public ArrayList<LeaveRequest> viewAllLeaveRequests() throws RemoteException, SQLException {
        return leaveRequestDao.viewAllLeaveRequests();
    }
}
