package EmployeeManagementSystem.client.model.LeaveRequestModel;

import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClient;
import EmployeeManagementSystem.client.networking.LeaveRequestClient.LeaveRequestClient;

public class LeaveRequestModelImpl implements LeaveRequestModel{
    private LeaveRequestClient leaveRequestClient;
    public LeaveRequestModelImpl(LeaveRequestClient leaveRequestClient) {this.leaveRequestClient = leaveRequestClient;
    }
}
