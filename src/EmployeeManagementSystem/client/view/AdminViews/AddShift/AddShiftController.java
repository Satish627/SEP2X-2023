package EmployeeManagementSystem.client.view.AdminViews.AddShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddShiftController implements ViewController {

    private ViewHandler viewHandler;
    private AddShiftViewModel addShiftViewModel;

    @FXML
    void onBackClicked(ActionEvent event) {
        openBackButton();

    }

    private void openBackButton() {
        viewHandler.openBackButton();
    }

    @FXML
    void onSaveClicked(ActionEvent event) {

    }


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        addShiftViewModel = viewModelFactory.getAddShiftViewModel();



    }
}
