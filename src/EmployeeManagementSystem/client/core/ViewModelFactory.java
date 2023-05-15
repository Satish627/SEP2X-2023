package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.view.AdminViews.AddEmployee.AddEmployeeViewModel;
import EmployeeManagementSystem.client.view.AdminViews.AddShift.AddShiftViewModel;
import EmployeeManagementSystem.client.view.AdminViews.EditEmployee.EditEmployeeViewModel;
import EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees.ViewAllEmployeesViewModel;
import EmployeeManagementSystem.client.view.EmployeeViews.EmployeeLeaveRequestPage.EmployeeLeaveRequestViewModel;
import EmployeeManagementSystem.client.view.LoginView.LoginViewModel;
import EmployeeManagementSystem.client.view.AdminViews.MainView.MainViewModel;
import EmployeeManagementSystem.client.view.AdminViews.ViewShift.ShiftViewModel;

public class ViewModelFactory {

    private final ModelFactory modelFactory;

    private LoginViewModel loginViewModel;
    private MainViewModel mainViewModel;
    private ViewAllEmployeesViewModel viewAllEmployeesViewModel;
    private AddEmployeeViewModel addEmployeeViewModel;
    private EditEmployeeViewModel editEmployeeViewModel;

    private ShiftViewModel shiftViewModel;

    private AddShiftViewModel addShiftViewModel;

    private EmployeeLeaveRequestViewModel employeeLeaveRequestViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel(){
        if(loginViewModel == null){
            loginViewModel = new LoginViewModel(modelFactory.getLoginModel());
        }
        return loginViewModel;
    }

    public MainViewModel getMainViewModel() {
        if(mainViewModel == null){
            mainViewModel = new MainViewModel(modelFactory.getEmployeeModel());
        }
        return mainViewModel;
    }


    public ViewAllEmployeesViewModel getEmployeeViewModel() {
        if(viewAllEmployeesViewModel == null)
        {
            viewAllEmployeesViewModel = new ViewAllEmployeesViewModel(modelFactory.getEmployeeModel());
        }
        return viewAllEmployeesViewModel;
    }

    public AddEmployeeViewModel getAddEmployeeViewModel() {
        if(addEmployeeViewModel == null)
        {
            addEmployeeViewModel = new AddEmployeeViewModel(modelFactory.getEmployeeModel());
        }
        return addEmployeeViewModel;
    }

    public ShiftViewModel getShiftViewModel()
    {
        if(shiftViewModel == null)
        {
            shiftViewModel = new ShiftViewModel(modelFactory.getViewShiftImpl());
        }
        return shiftViewModel;
    }
    public AddShiftViewModel getAddShiftViewModel()
    {
        if(addShiftViewModel== null)
        {
            addShiftViewModel= new AddShiftViewModel(modelFactory.getAddShiftModelImpl());
        }
        return addShiftViewModel;
    }


    public EmployeeLeaveRequestViewModel getEmployeeLeaveRequestViewModel() {

        if(employeeLeaveRequestViewModel== null)
        {
            employeeLeaveRequestViewModel= new EmployeeLeaveRequestViewModel(modelFactory.getLeaveRequest());
        }
        return employeeLeaveRequestViewModel;
    }

    public EditEmployeeViewModel getEditEmployeeViewModel() {
        if(editEmployeeViewModel== null)
        {
            editEmployeeViewModel= new EditEmployeeViewModel(modelFactory.getEditEmployee());
        }
        return editEmployeeViewModel;
    }
}
