package EmployeeManagementSystem.client.view.ViewShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ViewShiftController implements ViewController {

    private ViewHandler viewHandler;
    private ShiftViewModel shiftViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

        this.viewHandler = viewHandler;
        shiftViewModel = viewModelFactory.getShiftViewModel();

    }

    @FXML
    void onVIewShiftBackBtnClicked(ActionEvent event)
    {
        openMainView();

    }

    public void openMainView()
    {
        viewHandler.openMainView();
    }

}
