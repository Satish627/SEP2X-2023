package EmployeeManagementSystem.client.view.LeaveRequestView;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.AdminViews.MainView.MainViewModel;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LeaveRequestController implements ViewController
{
    private ViewHandler viewHandler;
    private MainViewModel mainViewModel;



        @FXML
        void approveClick(ActionEvent event) {

        }


        @FXML
        void rejectClick(ActionEvent event) {

        }
    @FXML
    void backClick(ActionEvent event) {
        viewHandler.openMainView();
    }



    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {

        this.viewHandler = viewHandler;
        mainViewModel = viewModelFactory.getMainViewModel();

    }
}
