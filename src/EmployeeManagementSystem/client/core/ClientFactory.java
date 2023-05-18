package EmployeeManagementSystem.client.core;


import EmployeeManagementSystem.client.networking.LoginClient.AdminClient;
import EmployeeManagementSystem.client.networking.LoginClient.AdminClientImpl;
import EmployeeManagementSystem.client.networking.ShiftClient.ShiftClient;
import EmployeeManagementSystem.client.networking.ShiftClient.ShiftClientImpl;
import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClient;
import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClientImpl;
import EmployeeManagementSystem.client.networking.LeaveRequestClient.LeaveRequestClient;
import EmployeeManagementSystem.client.networking.LeaveRequestClient.LeaveRequestClientImpl;
import EmployeeManagementSystem.client.networking.LoginClient.LoginClient;
import EmployeeManagementSystem.client.networking.LoginClient.LoginClientImpl;


public class ClientFactory {

    public EmployeeClient employeeClient;
    private LoginClient loginClient;

    private AdminClient adminClient;

    private LeaveRequestClient leaveRequestClient;
    public ShiftClient shiftClient;



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


    public LeaveRequestClient getLeaveRequestClient() {
        if (leaveRequestClient == null) {
            leaveRequestClient = new LeaveRequestClientImpl();
        }
        return leaveRequestClient;
    }
    public ShiftClient getAddShiftClient() {
        if (shiftClient == null) {
            shiftClient = new ShiftClientImpl();
        }
        return shiftClient;
    }

    public EmployeeClient getEditEmployeeClient() {
        if (employeeClient == null) {
            employeeClient = new EmployeeClientImpl();
        }
        return employeeClient;    }

    public AdminClient getAdminLoginClient() {
        if (adminClient == null){
            adminClient = new AdminClientImpl();
        }
        return adminClient;
    }
}
