package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.NumberStringConverter;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

public class ViewShiftController implements ViewController
{

    private ViewHandler viewHandler;
    private ViewShiftViewModel viewShiftViewModel;



    @FXML
    private TableColumn<Shift, String> checkInTime;

    @FXML
    private TableColumn<Shift, String> checkOutTime;

    @FXML
    private TableColumn<Shift, LocalDate> date;

    @FXML
    private TableColumn<Shift, Integer> employeeID;

    @FXML
    private TableColumn<Shift, String> ename;

    @FXML
    private TableColumn<Shift, Integer> shiftID;

    @FXML
    private TableColumn<Shift,Integer> totalHours;

    @FXML
    private TableColumn<Shift,String> status;
    @FXML
    private TableView<Shift> shiftListView;


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

        this.viewHandler = viewHandler;
        viewShiftViewModel = viewModelFactory.getShiftViewModel();
        initialiseTableView();

    }
    private void initialiseTableView() {
        shiftID.setCellValueFactory(new PropertyValueFactory<>("shiftID"));
        employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        ename.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        checkInTime.setCellValueFactory(new PropertyValueFactory<>("checkInTime"));
        checkOutTime.setCellValueFactory(new PropertyValueFactory<>("checkOutTime"));
        totalHours.setCellValueFactory(new PropertyValueFactory<>("totalHours"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
       shiftListView.setItems(viewShiftViewModel.viewAllShift());
    }

    @FXML
    void onViewShiftBackBtnClicked(ActionEvent event)
    {
        viewHandler.openMainView();

    }
    @FXML
    void OnAddShiftBtnClick(ActionEvent event) throws SQLException, RemoteException {
       viewHandler.openAddShiftView();
    }


    @FXML
    void removeShiftBtn(ActionEvent event)
    {
        try {
            Shift selectedItem = shiftListView.getSelectionModel().getSelectedItem();
            if (selectedItem == null) {
                AlertBox.showAlert("Please select a shift to update");
                return;
            }
            viewShiftViewModel.deleteShift(selectedItem.getShiftID());
            AlertBox.showAlert("Deleted successfully");
        } catch (Exception e) {
            AlertBox.showAlert(e.getMessage());
        }

    }


    public void onUpdateBtnClicked(ActionEvent event) {
        Shift selectedItem = shiftListView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            AlertBox.showAlert("Please select a shift to update");
            return;
        }
        viewShiftViewModel.updateShift(selectedItem);
        viewHandler.openUpdateShift();
    }
}
