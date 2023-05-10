package EmployeeManagementSystem.client.view.EmployeeViews.EmployeeLeaveRequestPage;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EmployeeLeaveRequestController implements ViewController {

    private ViewHandler viewHandler;
    private EmployeeLeaveRequestViewModel employeeLeaveRequestViewModel;


    @FXML
    void onEmployeeLeaveRequestBackBtnClicked(ActionEvent event) {


    }

    @FXML
    void onEmployeeLeaveRequestCancelBtnClicked(ActionEvent event) {

    }

    @FXML
    void onEmployeeLeaveRequestSubmitBtnClicked(ActionEvent event) {

    }


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

        this.viewHandler = viewHandler;
        employeeLeaveRequestViewModel = viewModelFactory.getEmployeeLeaveRequestViewModel();

    }
}
