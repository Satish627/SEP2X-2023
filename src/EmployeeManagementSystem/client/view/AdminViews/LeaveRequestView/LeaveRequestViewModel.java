package EmployeeManagementSystem.client.view.AdminViews.LeaveRequestView;

import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModel;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;
import java.util.List;

public class LeaveRequestViewModel
{
    private LeaveRequestModel leaveRequestModel;
    private ObservableList<LeaveRequest> leaveRequests;

    private IntegerProperty userID;

//    public LeaveRequestViewModel(LeaveRequestModelImpl leaveRequestModel)
//    {
//        this.leaveRequestModel=leaveRequestModel;
//        leaveRequests= FXCollections.observableList(leaveRequestModel.viewAllLeaveRequests());
//    }
    public LeaveRequestViewModel(LeaveRequestModelImpl leaveRequestModel) {
        this.leaveRequestModel = leaveRequestModel;

        List<LeaveRequest> requestList = leaveRequestModel.viewAllLeaveRequests();
        if (requestList != null) {
            leaveRequests = FXCollections.observableList(requestList);
        } else {
            leaveRequests = FXCollections.observableArrayList();
        }
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
