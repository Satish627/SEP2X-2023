package EmployeeManagementSystem.client.view.EmployeeViews.ViewShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.LoginView.EmployeeLogin.EmployeeLoginViewModel;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        private TableColumn<Shift, String> statusColumn;

        @FXML
        private TableColumn<Shift, Integer> totalHours;

        @FXML
        private TableView<Shift> employeeShiftView;

        @FXML
        private ComboBox<String> filterBox;

        @FXML
        private TextField totalHoursTF;



    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

        this.viewHandler = viewHandler;
        employeeViewShiftViewModel = viewModelFactory.getEmployeeViewShiftViewModel();
        employeeLoginViewModel=viewModelFactory.getLoginViewModel();
        filterBox.setItems(FXCollections.observableArrayList("ALL","UPCOMING", "PAST"));
        filterBox.setValue("ALL");
        filterBox.setOnAction(this::updateList);

        totalHoursTF.textProperty().bind(employeeViewShiftViewModel.getTotalHours());
        initializeTableView();

    }

    private void updateList(ActionEvent actionEvent) {
        switch (filterBox.getSelectionModel().getSelectedItem()){
            case  "ALL" :
                employeeViewShiftViewModel.allSelected();
                break;
            case "UPCOMING" :
                employeeViewShiftViewModel.upcomingSelected();
                break;
            case "PAST" :
                employeeViewShiftViewModel.pastSelected();

        }
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
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        employeeShiftView.setItems(employeeViewShiftViewModel.getShiftsToShow());



    }


    @FXML
    void onCheckInBtnClicked(ActionEvent event) {
        Shift selectedShift = employeeShiftView.getSelectionModel().getSelectedItem();
            LocalDate currentDate = LocalDate.now();
            if (selectedShift.getDate().isEqual(currentDate)) {
                openCheckInAlert();
                employeeViewShiftViewModel.checkIn(selectedShift.getShiftID(), selectedShift.getEmployeeID());
            } else {
                showDateWarning();
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
            LocalDateTime currentDate = LocalDateTime.now();
            if (selectedShift.getDate().isEqual(currentDate.toLocalDate()) && selectedShift.getCheckInTime() != null) {
                LocalTime checkOutDate = stringToLocalTime(selectedShift.getCheckOutTime());
                if (LocalTime.now().isBefore(checkOutDate)){
                    showWarning();
                    return;
                }
                openCheckOutAlert();
                employeeViewShiftViewModel.checkOut(selectedShift.getShiftID(), selectedShift.getEmployeeID());
            } else {
                showDateWarning();
            }
    }

    private void showWarning() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Shift Check-Out");
        alert.setHeaderText("Error");
        alert.setContentText("You cant checkout before the checkout time");
        alert.showAndWait();
    }

    private void showDateWarning() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Shift Check-Out");
        alert.setHeaderText("Error");
        alert.setContentText("You can only check in on the same day as the shift.");
        alert.showAndWait();
    }

    private LocalTime stringToLocalTime(String checkOutTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(checkOutTime, formatter);
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
