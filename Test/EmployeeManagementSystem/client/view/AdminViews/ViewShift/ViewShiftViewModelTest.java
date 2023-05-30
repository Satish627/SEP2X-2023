package EmployeeManagementSystem.client.view.AdminViews.ViewShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
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
        expectedShifts.add(new Shift(1,3, LocalDate.now(),"10:00", "17:00","Rohit"));
        expectedShifts.add(new Shift(2, 2, LocalDate.now(), "5:00", "10:00 AM", "Apurva"));

        when(shiftModel.viewAllShift()).thenReturn(new ArrayList<>(expectedShifts));

        // Act
        ArrayList<Shift> result = viewShiftViewModel.fetchAllShifts();

        // Assert
        assertEquals(expectedShifts, result);
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
//    @Test
//    void test_NewShiftAdded() {
//
//        Shift newShift = new Shift(1, 1,  LocalDate.now(), "08:00", "17:00");
//        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(this, "newShiftAdded", null, newShift);
//
//        List<Shift> shiftList = new ArrayList<>();
//        when(shiftModel.viewAllShift()).thenReturn((ArrayList<Shift>) shiftList);
//
//        viewShiftViewModel.newShiftAdded(propertyChangeEvent);
//
//
//        ObservableList<Shift> expectedShiftList = FXCollections.observableArrayList(newShift);
//        assertEquals(expectedShiftList, shiftModel.viewAllShift());
//    }
}







