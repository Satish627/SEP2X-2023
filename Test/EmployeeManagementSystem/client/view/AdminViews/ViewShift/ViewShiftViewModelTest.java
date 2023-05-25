package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ViewShiftViewModelTest
{
    private ViewShiftViewModel viewShiftViewModel;
    private ShiftModel shiftModel;

    @BeforeEach
    void setUp()
    {
        shiftModel = Mockito.mock(ShiftModel.class);
        viewShiftViewModel = new ViewShiftViewModel(shiftModel);
    }

    @Test
    public void testViewAllShift() throws RemoteException {
        // Arrange
        List<Shift> expectedShifts = new ArrayList<>();
        expectedShifts.add(new Shift(1, 12, "Rohit", LocalDate.now(), "09:00", "17:00"));
        expectedShifts.add(new Shift(2, 14, "Manisha", LocalDate.now(), "08:00", "16:00"));

        when(shiftModel.viewAllShift()).thenReturn(new ArrayList<>(expectedShifts));

        // Act
        ObservableList<Shift> actualShifts = viewShiftViewModel.viewAllShift();

        // Assert
        assertEquals(expectedShifts, actualShifts);
    }
}








