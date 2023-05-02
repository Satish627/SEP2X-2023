package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModelImpl;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.client.model.LoginModel.LoginModelImpl;
import EmployeeManagementSystem.client.model.ShiftModel.ViewShiftModelImpl;

public class ModelFactory {
    private final ClientFactory clientFactory;
    public LoginModelImpl loginModelImpl;
    public EmployeeModelImpl employeeModelImpl;
    public ViewShiftModelImpl viewShiftModelImpl;
    public LeaveRequestModelImpl leaveRequestImpl;



    public ModelFactory(ClientFactory clientFactory)
    {
        this.clientFactory = clientFactory;
    }
    public LoginModel getLoginModel(){
        if(loginModelImpl == null){
            loginModelImpl = (LoginModelImpl) new LoginModelImpl(clientFactory.getLoginClient());
        }
        return loginModelImpl;
    }

    public EmployeeModelImpl getEmployeeModel() {
        if (employeeModelImpl == null) {
            employeeModelImpl = new EmployeeModelImpl(clientFactory.getEmployeeClient());
        }
        return employeeModelImpl;
    }


    public ViewShiftModelImpl getViewShiftImpl()
    {
        if(viewShiftModelImpl == null)
        {
            viewShiftModelImpl = new ViewShiftModelImpl(clientFactory.getViewShiftClient());
        }
        return viewShiftModelImpl;
    }
    public LeaveRequestModelImpl getLeaveRequest()
    {
        if (leaveRequestImpl == null) {
            leaveRequestImpl = new LeaveRequestModelImpl(clientFactory.getLeaveRequestClient());
        }
        return leaveRequestImpl;
    }


}
