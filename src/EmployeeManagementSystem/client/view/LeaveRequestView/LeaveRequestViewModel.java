package EmployeeManagementSystem.client.view.LeaveRequestView;

import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModel;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;

public class LeaveRequestViewModel
{
    private LeaveRequestModel leaveRequestModel;
    private ObservableList<LeaveRequest> leaveRequests;

    public LeaveRequestViewModel(LeaveRequestModelImpl leaveRequestModel)
    {
        this.leaveRequestModel=leaveRequestModel;
        leaveRequests= FXCollections.observableList(leaveRequestModel.viewAllLeaveRequests());
    }



    public void approveLeave(int shiftID) throws RemoteException {
       leaveRequestModel.approveLeave(shiftID);
    }

    public void rejectLeave(int shiftID) throws RemoteException {
            leaveRequestModel.rejectLeave(shiftID);
    }

    public ObservableList<LeaveRequest> viewAllLeaveRequests(){
        return leaveRequests;
    }

}
