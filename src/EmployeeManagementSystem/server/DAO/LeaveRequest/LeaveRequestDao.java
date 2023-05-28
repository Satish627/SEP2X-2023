package EmployeeManagementSystem.server.DAO.LeaveRequest;

import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LeaveRequestDao
{
     void approveLeave(int shiftID) ;
    void rejectLeave(int shiftID) ;

    ArrayList<LeaveRequest> viewAllLeaveRequests() ;

    void requestLeave(int shiftID,String reason) ;


}
