package EmployeeManagementSystem.client.core;


import EmployeeManagementSystem.client.networking.AddShiftClient.AddShiftClient;
import EmployeeManagementSystem.client.networking.AddShiftClient.AddShiftClientImpl;
import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClient;
import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClientImpl;
import EmployeeManagementSystem.client.networking.LeaveRequestClient.LeaveRequestClient;
import EmployeeManagementSystem.client.networking.LeaveRequestClient.LeaveRequestClientImpl;
import EmployeeManagementSystem.client.networking.LoginClient.LoginClient;
import EmployeeManagementSystem.client.networking.LoginClient.LoginClientImpl;

import EmployeeManagementSystem.client.networking.ShiftsClient.ShiftsClient;
import EmployeeManagementSystem.client.networking.ShiftsClient.ShiftsClientImpl;

public class ClientFactory {

    public EmployeeClient employeeClient;
    private LoginClient loginClient;

    private ShiftsClient shiftsClient;
    private LeaveRequestClient leaveRequestClient;
    public AddShiftClient addShiftClient;



    public LoginClient getLoginClient() {
        if (loginClient == null){
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }

    public EmployeeClient getEmployeeClient() {
        if (employeeClient == null) {
           employeeClient= new EmployeeClientImpl();
        }
        return employeeClient;
    }


    public ShiftsClient getViewShiftClient()
    {
        if(shiftsClient == null)
        {
            shiftsClient = new ShiftsClientImpl();
        }
        return shiftsClient;
    }
    public LeaveRequestClient getLeaveRequestClient() {
        if (leaveRequestClient == null) {
            leaveRequestClient = new LeaveRequestClientImpl();
        }
        return leaveRequestClient;
    }
    public AddShiftClient getAddShiftClient() {
        if (addShiftClient == null) {
            addShiftClient = new AddShiftClientImpl();
        }
        return addShiftClient;
    }

}
