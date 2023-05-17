package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
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
    private TextField checkIn;
    @FXML
    private TextField checkOut;
    @FXML
    private TextField sId;
    @FXML
    private TextField eName;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField eId;


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
    private TableView<Shift> shiftListView;


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

        this.viewHandler = viewHandler;
        viewShiftViewModel = viewModelFactory.getShiftViewModel();
        initialiseTableView();
        bindTextFieldValues();


    }
    private void initialiseTableView() {
        shiftID.setCellValueFactory(new PropertyValueFactory<>("shiftID"));
        employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        ename.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        checkInTime.setCellValueFactory(new PropertyValueFactory<>("checkInTime"));
        checkOutTime.setCellValueFactory(new PropertyValueFactory<>("checkOutTime"));

       shiftListView.setItems(viewShiftViewModel.viewAllShift());
    }
    @FXML
    void getSelectedItem(MouseEvent mouseEvent) {
        int index = shiftListView.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        sId.setText(shiftID.getCellData(index).toString());
        eId.setText(employeeID.getCellData(index).toString());
        eName.setText(ename.getCellData(index));
        datePicker.setValue(date.getCellData(index));
        checkIn.setText(checkInTime.getCellData(index));
        checkOut.setText(checkOutTime.getCellData(index).toString());


    }



    @FXML
    void onVIewShiftBackBtnClicked(ActionEvent event)
    {
        viewHandler.openMainView();

    }
    @FXML
    void OnAddShiftBtnClick(ActionEvent event) throws SQLException, RemoteException {
        viewShiftViewModel.addShift();
        clearTextInput();

    }

    private void clearTextInput()
    {
        sId.setText(null);
        eId.setText(null);
        eName.setText(null);
        datePicker.setValue(null);
        checkIn.setText(null);
        checkOut.setText(null);
    }


    @FXML
    void removeShiftBtn(ActionEvent event)
    {
        viewShiftViewModel.deleteShift(Integer.parseInt(sId.getText()));
    }
    private void bindTextFieldValues() {
        sId.textProperty().bindBidirectional(viewShiftViewModel.getShiftID(), new NumberStringConverter());
        eId.textProperty().bindBidirectional(viewShiftViewModel.getEmployeeID(), new NumberStringConverter());
        eName.textProperty().bindBidirectional(viewShiftViewModel.getEmployeeName());
        datePicker.valueProperty().bindBidirectional(viewShiftViewModel.getDate());
        checkIn.textProperty().bindBidirectional(viewShiftViewModel.getCheckInTime());
        checkOut.textProperty().bindBidirectional(viewShiftViewModel.getCheckOutTime());
    }


//    @FXML
//    void editShiftClickBtn(ActionEvent event) {
//    int shiftId = Integer.parseInt(sId.getText());
//    int employeeId = Integer.parseInt(employeeID.getText());
//    String employeeName = eName.getText();
//    LocalDate date = datePicker.getValue();
//    String checkInTime = checkIn.getText();
//    String checkOutTime = checkOut.getText();
//
//    shiftViewModel.editShift(shiftId, employeeId, employeeName, date, checkInTime, checkOutTime);
//}


}
