package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModelImpl;
import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModelImpl;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.client.model.LoginModel.LoginModelImpl;

public class ModelFactory {
    private final ClientFactory clientFactory;
    private LoginModelImpl loginModelImpl;
    private EmployeeModelImpl employeeModelImpl;
    private ShiftModelImpl shiftModelImpl;
    private LeaveRequestModelImpl leaveRequestImpl;



    public ModelFactory(ClientFactory clientFactory)
    {
        this.clientFactory = clientFactory;
    }
    public LoginModel getLoginModel(){
        if(loginModelImpl == null){
            loginModelImpl =  new LoginModelImpl(clientFactory.getLoginClient());
        }
        return loginModelImpl;
    }

    public EmployeeModelImpl getEmployeeModel() {
        if (employeeModelImpl == null) {
            employeeModelImpl = new EmployeeModelImpl(clientFactory.getEmployeeClient());
        }
        return employeeModelImpl;
    }


    public ShiftModelImpl getShiftModelImpl()
    {
        if(shiftModelImpl == null)
        {
            shiftModelImpl = new ShiftModelImpl(clientFactory.getShiftClient());
        }
        return shiftModelImpl;
    }
    public LeaveRequestModelImpl getLeaveRequest()
    {
        if (leaveRequestImpl == null) {
            leaveRequestImpl = new LeaveRequestModelImpl(clientFactory.getLeaveRequestClient());
        }
        return leaveRequestImpl;
    }

}
