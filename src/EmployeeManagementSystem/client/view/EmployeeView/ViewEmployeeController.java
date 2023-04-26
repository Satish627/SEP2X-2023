package EmployeeManagementSystem.client.view.EmployeeView;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ViewEmployeeController implements ViewController
{
    private ViewHandler viewHandler;
    private EmployeeViewModel employeeViewModel;

    @FXML
    void backClick(ActionEvent event)
    {
        backPage();

    }

    private void backPage()
    {
        viewHandler.backPage();
    }


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        employeeViewModel = viewModelFactory.getEmployeeViewModel();


    }
}
