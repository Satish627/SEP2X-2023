package EmployeeManagementSystem.client.view.AdminViews.AddShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.client.model.ShiftModel.ShiftModelImpl;
import EmployeeManagementSystem.client.networking.ShiftClient.ShiftClient;
import EmployeeManagementSystem.client.networking.ShiftClient.ShiftClientImpl;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AddShiftViewModelTest
{
    private AddShiftViewModel shiftViewModel;
    private ShiftModel shiftModel;
    private IntegerProperty shiftID, employeeID;
    private StringProperty startTime, endTime;
    private StringProperty employeeName;
    private ObjectProperty<LocalDate> date;


    @BeforeEach
    void setUp()
    {
        shiftModel = Mockito.mock(ShiftModel.class);
       shiftViewModel = new AddShiftViewModel(shiftModel);



       shiftID = new SimpleIntegerProperty(0);
       employeeID = new SimpleIntegerProperty(0);
       employeeName = new SimpleStringProperty("");
       date = new SimpleObjectProperty<>();
       startTime = new SimpleStringProperty("");
       endTime = new SimpleStringProperty("");

    }

    @Test
    public void add_missingEmployeeName() throws SQLException, RemoteException {
        int employeeID = 0;
        String employeeName = null; //employeeName is null
        LocalDate date = LocalDate.now();
        String startTime= "";
        String endTime = "";

        Shift addedShift = shiftViewModel.addShift();
        System.out.println("Fields can not be empty.");

        assertNull(addedShift);
    }

    @Test
    public void addShiftWithNegativeShiftID() throws IOException, SQLException {
        shiftViewModel.getShiftID().set(-1);
        shiftViewModel.getEmployeeID().set(0);
        shiftViewModel.getEmployeeName().set("");
        shiftViewModel.getDate().set(LocalDate.now());
        shiftViewModel.getStartTime().set("");
        shiftViewModel.getEndTime().set("");

        Shift result = shiftViewModel.addShift();


        assertNull(result);




    }
    @Test
    public void testAddShift() throws IOException, SQLException {
        // Arrange
        int shiftID = 1;
        int employeeID = 2;
        String employeeName = "John Doe";
        LocalDate date = LocalDate.now();
        String startTime = "09:00";
        String endTime = "17:00";
        Shift expectedShift = new Shift(shiftID, employeeID, employeeName, date, startTime, endTime);

        shiftViewModel.getShiftID().set(shiftID);
        shiftViewModel.getEmployeeID().set(employeeID);
        shiftViewModel.getEmployeeName().set(employeeName);
        shiftViewModel.getDate().set(date);
        shiftViewModel.getStartTime().set(startTime);
        shiftViewModel.getEndTime().set(endTime);

        when(shiftModel.addShift(shiftID, employeeID, employeeName, date, startTime, endTime))
                .thenReturn(expectedShift);

        // Act
        Shift actualShift = shiftModel.addShift(shiftID,employeeID,employeeName,date,startTime,endTime);

        // Assert
        verify(shiftModel).addShift(shiftID, employeeID, employeeName, date, startTime, endTime);
        assertEquals(expectedShift, actualShift);
        System.out.println("Shift has added successfully.");
    }
}



