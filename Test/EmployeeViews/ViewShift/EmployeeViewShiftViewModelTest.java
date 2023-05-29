package EmployeeViews.ViewShift;
import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.client.view.EmployeeViews.ViewShift.EmployeeViewShiftViewModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class EmployeeViewShiftViewModelTest {
    @Mock
    private ShiftModel shiftModel;
    @Mock
    private LoginModel loginModel;

    private EmployeeViewShiftViewModel viewModel;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(loginModel.getCurrentUserId()).thenReturn(1); // Mocking the current user ID
        List<Shift> allShifts = new ArrayList<>(); // Creating a list of shifts
        //when(shiftModel.viewAllShiftByUserID(anyInt())).thenReturn(allShifts);
        viewModel = new EmployeeViewShiftViewModel(shiftModel, loginModel);
    }

    @Test
    public void testGetShiftsToShow() {
        ObservableList<Shift> shiftsToShow = viewModel.getShiftsToShow();
        assertNotNull(shiftsToShow);
    }

    @Test
    public void testCheckIn() {
        int shiftID = 1;
        int userId = 1;
        viewModel.checkIn(shiftID, userId);
        verify(shiftModel, times(1)).checkIn(eq(shiftID), eq(userId));
    }

    @Test
    public void testCheckOut() {
        int shiftID = 1;
        int userId = 1;
        viewModel.checkOut(shiftID, userId);
        verify(shiftModel, times(1)).checkOut(eq(shiftID), eq(userId));
    }

    @Test
    public void testAllSelected() {
        ArgumentCaptor<List<Shift>> shiftsCaptor = ArgumentCaptor.forClass(List.class);
        viewModel.allSelected();
        verify(shiftModel, times(1)).viewAllShiftByUserID(anyInt());
        verify(viewModel.getShiftsToShow(), times(1)).setAll(shiftsCaptor.capture());
        List<Shift> shifts = shiftsCaptor.getValue();
        assertNotNull(shifts);
        assertTrue(shifts.isEmpty());
    }

    @Test
    public void testUpcomingSelected() {
        LocalDate now = LocalDate.now();
        List<Shift> upcomingShifts = new ArrayList<>();
        upcomingShifts.add(new Shift(1, 1, now.plusDays(1), "09:00", "17:00"));
        upcomingShifts.add(new Shift(2, 1, now.plusDays(2), "09:00", "17:00"));
        upcomingShifts.add(new Shift(3, 1, now.plusDays(3), "09:00", "17:00"));
        //when(shiftModel.viewAllShiftByUserID(anyInt())).thenReturn(upcomingShifts);

        ArgumentCaptor<List<Shift>> shiftsCaptor = ArgumentCaptor.forClass(List.class);
        viewModel.upcomingSelected();
        verify(shiftModel, times(1)).viewAllShiftByUserID(anyInt());
        verify(viewModel.getShiftsToShow(), times(1)).setAll(shiftsCaptor.capture());
        List<Shift> shifts = shiftsCaptor.getValue();
        assertNotNull(shifts);
        assertEquals(upcomingShifts.size(), shifts.size());
    }

    @Test
    public void testPastSelected() {
        LocalDate now = LocalDate.now();
        List<Shift> pastShifts = new ArrayList<>();
        pastShifts.add(new Shift(1, 1, now.minusDays(1), "09:00", "17:00"));
        pastShifts.add(new Shift(2, 1, now.minusDays(2), "09:00", "17:00"));
        pastShifts.add(new Shift(3, 1, now.minusDays(3), "09:00", "17:00"));
        //when(shiftModel.viewAllShiftByUserID(anyInt())).thenReturn(pastShifts);

        ArgumentCaptor<List<Shift>> shiftsCaptor = ArgumentCaptor.forClass(List.class);
        viewModel.pastSelected();
        verify(shiftModel, times(1)).viewAllShiftByUserID(anyInt());
        verify(viewModel.getShiftsToShow(), times(1)).setAll(shiftsCaptor.capture());
        List<Shift> shifts = shiftsCaptor.getValue();
        assertNotNull(shifts);
        assertEquals(pastShifts.size(), shifts.size());
    }

    @Test
    public void testCalculateTotalHours() {
        List<Shift> shifts = new ArrayList<>();
        shifts.add(new Shift(1, 1, LocalDate.now(), "09:00", "17:00"));
        shifts.add(new Shift(2, 1, LocalDate.now(), "08:00", "16:00"));
        when(viewModel.getShiftsToShow()).thenReturn(FXCollections.observableArrayList(shifts));
        StringProperty totalHours = viewModel.getTotalHours();
        assertNotNull(totalHours);
        assertEquals("16", totalHours.get());
    }
}