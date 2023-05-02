package EmployeeManagementSystem.client.view.AdminViews.MainView;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModelImpl;
;

public class MainViewModel {
    private EmployeeModel employeeModel;
    public MainViewModel(EmployeeModelImpl mainModel)
    {
        this.employeeModel = employeeModel;
    }
}
