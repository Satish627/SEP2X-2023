package EmployeeManagementSystem.client.view.MainView;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;

public class MainController implements ViewController {
    private ViewHandler viewHandler;
    private MainViewModel mainViewModel;
    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        mainViewModel = viewModelFactory.getMainViewModel();

    }
}
