package EmployeeManagementSystem.client.view.AdminViews.LeaveRequestView;

import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModel;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import EmployeeManagementSystem.shared.model.LeaveRequest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;
import java.util.List;

public class LeaveRequestViewModel
{
    private LeaveRequestModel leaveRequestModel;
    private ObservableList<LeaveRequest> leaveRequests;


    public LeaveRequestViewModel(LeaveRequestModel leaveRequestModel) {
        this.leaveRequestModel = leaveRequestModel;

        List<LeaveRequest> requestList = null;
        try {
            requestList = leaveRequestModel.viewAllLeaveRequests();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        if (requestList != null) {
            leaveRequests = FXCollections.observableList(requestList);
        } else {
            leaveRequests = FXCollections.observableArrayList();
        }
    }



    public void approveLeave(int shiftID) throws RemoteException {
        if (shiftID==0) {
            System.out.println("ShiftID is null");
        } else {
            leaveRequestModel.approveLeave(shiftID);
        }
    }

    public void rejectLeave(int shiftID) throws RemoteException {
        if (shiftID==0) {
            System.out.println("ShiftID is null");
        } else {
            leaveRequestModel.rejectLeave(shiftID);
        }
    }

    public ObservableList<LeaveRequest> viewAllLeaveRequests(){
        return leaveRequests;
    }

}
