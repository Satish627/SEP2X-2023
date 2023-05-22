package EmployeeManagementSystem.server.DAO.LeaveRequest;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LeaveRequestDao
{
     void approveLeave(int shiftID) throws SQLException;
    void rejectLeave(int shiftID) throws SQLException;

    ArrayList<LeaveRequest> viewAllLeaveRequests() throws SQLException;

    void requestLeave(int shiftID,String reason) throws SQLException;


}
