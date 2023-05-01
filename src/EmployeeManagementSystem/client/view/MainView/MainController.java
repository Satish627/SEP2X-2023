package EmployeeManagementSystem.client.view.MainView;


import javafx.event.ActionEvent;


import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.fxml.FXML;

public class MainController implements ViewController {
    private ViewHandler viewHandler;
    private MainViewModel mainViewModel;

    @FXML
    void viewEmployeeLink(ActionEvent event)
    {
        openEmployeeView();
    }


    private void openEmployeeView()

    {
        viewHandler.openEmployeeView();
    }

    @FXML
    void ViewShiftLink(ActionEvent event)
    {
        openViewShift();
    }

    private void openViewShift() {
        viewHandler.openViewShift();
    }

    @FXML
    void leaveRequestLink(ActionEvent event)
    {
        leaveRequest();

    }

    private void leaveRequest()
    {
        viewHandler.leaveRequest();
    }


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        mainViewModel = viewModelFactory.getMainViewModel();

    }
}
