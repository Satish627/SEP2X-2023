package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.view.EmployeeView.EmployeeViewModel;
import EmployeeManagementSystem.client.view.LoginView.LoginViewModel;
import EmployeeManagementSystem.client.view.MainView.MainViewModel;

public class ViewModelFactory {

    private final ModelFactory modelFactory;

    private LoginViewModel loginViewModel;
    private MainViewModel mainViewModel;
    private EmployeeViewModel employeeViewModel;

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

    public EmployeeViewModel getEmployeeViewModel()
    {
        if(employeeViewModel == null)
        {
            employeeViewModel = new EmployeeViewModel(modelFactory.getAddEmployee());
        }
        return employeeViewModel;
    }
}
