package EmployeeManagementSystem.client.view;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;


public interface ViewController {

    void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory);
}
