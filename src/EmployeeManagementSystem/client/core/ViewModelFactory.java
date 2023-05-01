package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.view.AddEmployee.AddEmployeeViewModel;
import EmployeeManagementSystem.client.view.AddShift.AddShiftViewModel;
import EmployeeManagementSystem.client.view.EmployeeView.EmployeeViewModel;
import EmployeeManagementSystem.client.view.LoginView.LoginViewModel;
import EmployeeManagementSystem.client.view.MainView.MainViewModel;
import EmployeeManagementSystem.client.view.ViewShift.ShiftViewModel;

public class ViewModelFactory {

    private final ModelFactory modelFactory;

    private LoginViewModel loginViewModel;
    private MainViewModel mainViewModel;
    private EmployeeViewModel employeeViewModel;
    private AddEmployeeViewModel addEmployeeViewModel;

    private ShiftViewModel shiftViewModel;

    private AddShiftViewModel addShiftViewModel;

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
            mainViewModel = new MainViewModel(modelFactory.getMainModel());
        }
        return mainViewModel;
    }


    public EmployeeViewModel getEmployeeViewModel() {
        if(employeeViewModel == null)
        {
            employeeViewModel = new EmployeeViewModel(modelFactory.getEmployeeModel());
        }
        return employeeViewModel;
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
            addShiftViewModel= new AddShiftViewModel(modelFactory.getAddShiftImpl());
        }
        return addShiftViewModel;
    }



}
