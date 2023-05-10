package EmployeeManagementSystem.server.networking.LeaveRequest;

import EmployeeManagementSystem.server.DAO.LeaveRequest.LeaveRequestDao;
import EmployeeManagementSystem.server.DAO.Login.LoginDAO;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.networking.LeaveRequestServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class LeaveRequestServerImpl implements LeaveRequestServer
{

    private LeaveRequestDao leaveRequestDao;

    public LeaveRequestServerImpl(LeaveRequestDao leaveRequestDao) throws RemoteException{
        this.leaveRequestDao=leaveRequestDao;
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public LeaveRequest approveLeave(int shiftID, String reason) throws RemoteException {
        return leaveRequestDao.approveLeave(shiftID,reason);
    }
}
