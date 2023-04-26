package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClient;
import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClientImpl;
import EmployeeManagementSystem.client.networking.LoginClient.LoginClient;
import EmployeeManagementSystem.client.networking.LoginClient.LoginClientImpl;
import EmployeeManagementSystem.client.networking.MainViewClient.MainClient;
import EmployeeManagementSystem.client.networking.MainViewClient.MainClientImpl;

public class ClientFactory {

    public EmployeeClient employeeClient;
    private LoginClient loginClient;
    private MainClient mainClient;


    public LoginClient getLoginClient() {
        if (loginClient == null){
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }

    public MainClient getMainClient() {
        if (mainClient == null) {
            mainClient = new MainClientImpl();
        }
        return mainClient;
    }
    public EmployeeClient getEmployeeClient() {
        if (employeeClient == null) {
           employeeClient= new EmployeeClientImpl();
        }
        return employeeClient;
    }



}
