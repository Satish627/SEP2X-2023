package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModelImpl;
import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModelImpl;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.client.model.LoginModel.LoginModelImpl;

public class ModelFactory {
    private final ClientFactory clientFactory;
    public LoginModelImpl loginModelImpl;
    public EmployeeModelImpl employeeModelImpl;
    public ShiftModelImpl viewShiftModelImpl;
    public LeaveRequestModelImpl leaveRequestImpl;
    public ShiftModelImpl addShiftModelImpl;



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


    public ShiftModelImpl getViewShiftImpl()
    {
        if(viewShiftModelImpl == null)
        {
            viewShiftModelImpl = new ShiftModelImpl(clientFactory.getAddShiftClient());
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
    public ShiftModelImpl getAddShiftModelImpl()
    {
        if (addShiftModelImpl == null) {
            addShiftModelImpl = new ShiftModelImpl(clientFactory.getAddShiftClient());
        }
        return addShiftModelImpl;
    }


}
