package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.client.model.ShiftModel.ShiftModelImpl;
import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.model.Users;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.util.converter.NumberStringConverter;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShiftViewModel {

    private ShiftModel shiftModel;
    private ObservableList<Shift> shiftObservableList;
    private StringProperty employeeName,checkInTime,checkOutTime;
    private IntegerProperty shiftID,employeeID;
    ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    public ShiftViewModel(ShiftModel shiftModel)
    {
        this.shiftModel = shiftModel;
        shiftObservableList= FXCollections.observableList(shiftModel.viewAllShift());
        NumberStringConverter numberStringConverter = new NumberStringConverter();
        initialiseAllProperty();

    }
    private void initialiseAllProperty() {
        shiftID = new SimpleIntegerProperty();
        employeeID = new SimpleIntegerProperty();
        employeeName= new SimpleStringProperty();
        date = new SimpleObjectProperty<>();
        checkInTime = new SimpleStringProperty();
        checkOutTime = new SimpleStringProperty();

    }

    public ObservableList<Shift> viewAllShift()
    {
        return shiftObservableList;
    }




    public Shift addShift() throws SQLException, RemoteException {
        return shiftModel.addShift(shiftID.get(),employeeID.get(), employeeName.get(), date.get(), checkInTime.get(), checkOutTime.get());
    }


    public void editShift(int shiftId, int employeeId, String employeeName, LocalDate date, String checkInTime, String checkOutTime)
    {
    }
}
