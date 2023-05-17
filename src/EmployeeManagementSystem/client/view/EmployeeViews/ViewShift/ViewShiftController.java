package EmployeeManagementSystem.client.view.EmployeeViews.ViewShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.AdminViews.ViewShift.ViewShiftViewModel;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class ViewShiftController implements ViewController {

    private ViewHandler viewHandler;

    private ViewShiftViewModel viewShiftViewModel;
    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

        this.viewHandler = viewHandler;
        viewShiftViewModel = viewModelFactory.getShiftViewModel();

    }


    @FXML
    void onCheckInBtnClicked(ActionEvent event) {

        openCheckInAlert();



    }

    private void openCheckInAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Shift Check-In");
        alert.setHeaderText("Confirm Check-In");
        alert.setContentText("Your shift has started!");
        alert.showAndWait();
    }

    @FXML
    void onCheckOutBtnClicked(ActionEvent event) {

        openCheckOutAlert();

    }

    private void openCheckOutAlert() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Shift Check-Out");
        alert.setHeaderText("Confirm Check-Out");
        alert.setContentText("Your shift has finished!");
        alert.showAndWait();
    }

    @FXML
    void onLeaveRequestBtnClicked(ActionEvent event) {

        viewHandler.openEmployeeLeaveRequestPage();

    }




}
