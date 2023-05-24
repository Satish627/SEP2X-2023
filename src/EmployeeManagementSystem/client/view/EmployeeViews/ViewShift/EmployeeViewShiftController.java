package EmployeeManagementSystem.client.view.EmployeeViews.ViewShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees.ViewAllEmployeesViewModel;
import EmployeeManagementSystem.client.view.LoginView.EmployeeLogin.EmployeeLoginViewModel;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class EmployeeViewShiftController implements ViewController {

    private ViewHandler viewHandler;
    private EmployeeViewShiftViewModel employeeViewShiftViewModel;
    private EmployeeLoginViewModel employeeLoginViewModel;
        @FXML
        private TableColumn<Shift, String> checkInTime;

        @FXML
        private TableColumn<Shift, String> checkOutTime;

        @FXML
        private TableColumn<Shift, LocalDate> date;

        @FXML
        private TableColumn<Shift, Integer> eID;

        @FXML
        private TableColumn<Shift, String> employeeName;

        @FXML
        private TableColumn<Shift, String> shiftID;

        @FXML
        private TableColumn<Shift, Integer> totalHours;

        @FXML
        private TableView<Shift> employeeShiftView;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

        this.viewHandler = viewHandler;
        employeeViewShiftViewModel = viewModelFactory.getEmployeeViewShiftViewModel();
        employeeLoginViewModel=viewModelFactory.getLoginViewModel();
        initializeTableView();

    }

    private void initializeTableView()
    {
        shiftID.setCellValueFactory(new PropertyValueFactory<>("shiftID"));
        eID.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        employeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        checkInTime.setCellValueFactory(new PropertyValueFactory<>("checkInTime"));
        checkOutTime.setCellValueFactory(new PropertyValueFactory<>("checkOutTime"));
        totalHours.setCellValueFactory(new PropertyValueFactory<>("totalHours"));
        employeeShiftView.setItems(employeeViewShiftViewModel.viewAllShiftsByUserID(employeeLoginViewModel.login().getUserId()));

    }


    @FXML
    void onCheckInBtnClicked(ActionEvent event) {
        Shift selectedShift = employeeShiftView.getSelectionModel().getSelectedItem();
        if (selectedShift != null && selectedShift.getEmployeeID() == employeeLoginViewModel.login().getUserId()) {
            LocalDate currentDate = LocalDate.now();
            if (selectedShift.getDate().isEqual(currentDate)) {
                openCheckInAlert();
                employeeViewShiftViewModel.checkIn(selectedShift.getShiftID(), selectedShift.getEmployeeID());
            } else {
                System.out.println("You can only check in on the same day as the shift.");
            }
        } else {
            System.out.println("Unauthorized access");
        }
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
        Shift selectedShift = employeeShiftView.getSelectionModel().getSelectedItem();
        if (selectedShift != null && selectedShift.getEmployeeID() == employeeLoginViewModel.login().getUserId()) {
            LocalDate currentDate = LocalDate.now();
            if (selectedShift.getDate().isEqual(currentDate) && selectedShift.getCheckInTime() != null) {
                openCheckOutAlert();
                employeeViewShiftViewModel.checkOut(selectedShift.getShiftID(), selectedShift.getEmployeeID());
            } else {
                System.out.println("You can only check out on the same day as the shift and after checking in.");
            }
        } else {
            System.out.println("Unauthorized access");
        }
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
