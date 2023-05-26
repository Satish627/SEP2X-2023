package EmployeeManagementSystem.client.view.AdminViews.AddShift;
import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddShiftViewModelTest {
    private AddShiftViewModel addShiftViewModel;

    @Mock
    private ShiftModel shiftModel;

    @BeforeEach
    public void setup() {
        shiftModel= Mockito.mock(ShiftModel.class);
        addShiftViewModel = new AddShiftViewModel(shiftModel);
    }

    @Test
    public void testAddShift_WithValidData_ShouldReturnShift() throws SQLException, RemoteException {
        // Arrange
        int shiftID = 1;
        int employeeID = 1;
        String employeeName = "John Doe";
        LocalDate date = LocalDate.now();
        String startTime = "09:00";
        String endTime = "17:00";

        Shift expectedShift = new Shift(shiftID, employeeID, employeeName, date, startTime, endTime);
        when(shiftModel.addShift(shiftID, employeeID, employeeName, date, startTime, endTime)).thenReturn(expectedShift);

        addShiftViewModel.getShiftID().set(shiftID);
        addShiftViewModel.getEmployeeID().set(employeeID);
        addShiftViewModel.getEmployeeName().set(employeeName);
        addShiftViewModel.getDate().set(date);
        addShiftViewModel.getStartTime().set(startTime);
        addShiftViewModel.getEndTime().set(endTime);

        // Act
        Shift resultShift = addShiftViewModel.addShift();

        // Assert
        assertNotNull(resultShift);
        assertEquals(expectedShift, resultShift);
        verify(shiftModel, times(1)).addShift(shiftID, employeeID, employeeName, date, startTime, endTime);
    }

    @Test
    public void testAddShift_WithMissingData_ShouldReturnNull() throws SQLException, RemoteException {
        // Arrange
        addShiftViewModel.getShiftID().set(0);
        addShiftViewModel.getEmployeeID().set(0);
        addShiftViewModel.getEmployeeName().set(null);
        addShiftViewModel.getDate().set(null);
        addShiftViewModel.getStartTime().set(null);
        addShiftViewModel.getEndTime().set(null);

        // Act
        Shift resultShift = addShiftViewModel.addShift();

        // Assert
        assertNull(resultShift);
        verifyNoInteractions(shiftModel);
    }

    @Test
    public void testAddShift_WithPartialData_ShouldReturnNull() throws SQLException, RemoteException {
        // Arrange
        int shiftID = 1;
        int employeeID = 1;
        String employeeName = "John Doe";
        LocalDate date = LocalDate.now();
        String startTime = "09:00";

        addShiftViewModel.getShiftID().set(shiftID);
        addShiftViewModel.getEmployeeID().set(employeeID);
        addShiftViewModel.getEmployeeName().set(employeeName);
        addShiftViewModel.getDate().set(date);
        addShiftViewModel.getStartTime().set(startTime);

        // Act
        Shift resultShift = addShiftViewModel.addShift();

        // Assert
        assertNull(resultShift);
        verifyNoInteractions(shiftModel);
    }
}
