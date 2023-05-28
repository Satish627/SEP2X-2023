package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViewShiftViewModelTest {
    private ViewShiftViewModel viewShiftViewModel;
    private ShiftModel shiftModel;

    @BeforeEach
    void setUp() {
        shiftModel = mock(ShiftModel.class);
        viewShiftViewModel = new ViewShiftViewModel(shiftModel);
    }

    @Test
    public void testViewAllShifts() {
        // Arrange
        List<Shift> expectedShifts = new ArrayList<>();
        expectedShifts.add(new Shift(1, 1, "John Doe", null, "09:00 AM", "05:00 PM"));
        expectedShifts.add(new Shift(2, 2, "Jane Smith", null, "10:00 AM", "06:00 PM"));

        when(shiftModel.viewAllShift()).thenReturn(new ArrayList<>(expectedShifts));

        // Act
        ArrayList<Shift> result = viewShiftViewModel.fetchAllShifts();

        // Assert
        assertEquals(expectedShifts, result);
    }

    @Test
    public void testAddShift() {
        // Arrange
        int shiftID = 1;
        int employeeID = 1;
        String employeeName = "John Doe";
        LocalDate date = LocalDate.now();
        String checkInTime = "09:00 AM";
        String checkOutTime = "05:00 PM";
        Shift shift = new Shift(shiftID, employeeID, employeeName, date, checkInTime, checkOutTime);

        when(shiftModel.addShift(shiftID, employeeID, employeeName, date, checkInTime, checkOutTime)).thenReturn(shift);
        viewShiftViewModel.getShiftID().set(shiftID);
        viewShiftViewModel.getEmployeeID().set(employeeID);
        viewShiftViewModel.getDate().set(date);
        viewShiftViewModel.getEmployeeName().set(employeeName);
        viewShiftViewModel.getCheckOutTime().set(checkOutTime);
        viewShiftViewModel.getCheckInTime().set(checkInTime);

        Shift result = viewShiftViewModel.addShift();
        // Assert
        assertEquals(shift, result);
    }

    @Test
    public void testDeleteShift() {
        // Arrange
        int shiftID = 1;

        // Act
        viewShiftViewModel.deleteShift(shiftID);

        // Assert
        verify(shiftModel).deleteShift(shiftID);
    }
}







