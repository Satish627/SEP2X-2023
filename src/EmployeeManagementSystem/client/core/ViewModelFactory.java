package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.view.AdminViews.AddShift.AddShiftViewModel;
import EmployeeManagementSystem.client.view.AdminViews.UpdateShift.UpdateShiftViewModel;
import EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees.ViewAllEmployeesViewModel;
import EmployeeManagementSystem.client.view.EmployeeViews.EmployeeLeaveRequestPage.EmployeeLeaveRequestViewModel;
import EmployeeManagementSystem.client.view.AdminViews.LeaveRequestView.LeaveRequestViewModel;
import EmployeeManagementSystem.client.view.EmployeeViews.ViewShift.EmployeeViewShiftViewModel;
import EmployeeManagementSystem.client.view.LoginView.AdminLogin.AdminLoginViewModel;
import EmployeeManagementSystem.client.view.LoginView.EmployeeLogin.EmployeeLoginViewModel;
import EmployeeManagementSystem.client.view.AdminViews.MainView.MainViewModel;
import EmployeeManagementSystem.client.view.AdminViews.ViewShift.ViewShiftViewModel;

public class ViewModelFactory {

    private final ModelFactory modelFactory;

    private EmployeeLoginViewModel employeeLoginViewModel;
    private AdminLoginViewModel adminLoginViewModel;
    private MainViewModel mainViewModel;
    private ViewAllEmployeesViewModel viewAllEmployeesViewModel;

    private ViewShiftViewModel viewShiftViewModel;

    private AddShiftViewModel addShiftViewModel;
    private LeaveRequestViewModel leaveRequestViewModel;

    private EmployeeLeaveRequestViewModel employeeLeaveRequestViewModel;

    private EmployeeViewShiftViewModel employeeViewShiftViewModel;
    private UpdateShiftViewModel updateShiftViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public EmployeeLoginViewModel getLoginViewModel() {
        if (employeeLoginViewModel == null) {
            employeeLoginViewModel = new EmployeeLoginViewModel(modelFactory.getLoginModel());
        }
        return employeeLoginViewModel;
    }

    public MainViewModel getMainViewModel() {
        if (mainViewModel == null) {
            mainViewModel = new MainViewModel(modelFactory.getEmployeeModel());
        }
        return mainViewModel;
    }


    public ViewAllEmployeesViewModel getEmployeeViewModel() {
        if (viewAllEmployeesViewModel == null) {
            viewAllEmployeesViewModel = new ViewAllEmployeesViewModel(modelFactory.getEmployeeModel());
        }
        return viewAllEmployeesViewModel;
    }

    public ViewShiftViewModel getShiftViewModel() {
        if (viewShiftViewModel == null) {
            viewShiftViewModel = new ViewShiftViewModel(modelFactory.getShiftModelImpl());
        }
        return viewShiftViewModel;
    }

    public AddShiftViewModel getAddShiftViewModel() {
        if (addShiftViewModel == null) {
            addShiftViewModel = new AddShiftViewModel(modelFactory.getShiftModelImpl());
        }
        return addShiftViewModel;
    }


    public EmployeeLeaveRequestViewModel getEmployeeLeaveRequestViewModel() {

        if (employeeLeaveRequestViewModel == null) {
            employeeLeaveRequestViewModel = new EmployeeLeaveRequestViewModel(modelFactory.getLeaveRequest());
        }
        return employeeLeaveRequestViewModel;
    }

    public LeaveRequestViewModel getLeaveRequestViewModel() {
        if (leaveRequestViewModel == null) {
            leaveRequestViewModel = new LeaveRequestViewModel(modelFactory.getLeaveRequest());
        }
        return leaveRequestViewModel;
    }


    public AdminLoginViewModel getAdminLoginViewModel() {
        if (adminLoginViewModel == null) {
            adminLoginViewModel = new AdminLoginViewModel(modelFactory.getLoginModel());
        }
        return adminLoginViewModel;
    }

    public EmployeeViewShiftViewModel getEmployeeViewShiftViewModel() {
        if (employeeViewShiftViewModel == null) {
            employeeViewShiftViewModel = new EmployeeViewShiftViewModel(modelFactory.getShiftModelImpl(), modelFactory.getLoginModel());
        }
        return employeeViewShiftViewModel;
    }

    public UpdateShiftViewModel getUpdateShiftViewModel() {
        if (updateShiftViewModel == null) {
            updateShiftViewModel = new UpdateShiftViewModel(modelFactory.getShiftModelImpl());
        }
        return updateShiftViewModel;
    }


}
