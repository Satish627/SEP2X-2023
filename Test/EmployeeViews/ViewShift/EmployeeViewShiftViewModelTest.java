
package EmployeeViews.ViewShift;

import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.client.view.EmployeeViews.ViewShift.EmployeeViewShiftViewModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeViewShiftViewModelTest {

    @Mock
    private ShiftModel shiftModel;
    @Mock
    private LoginModel loginModel;
    private EmployeeViewShiftViewModel employeeViewShiftModelTest;

    @BeforeEach
    public void setUp() {
        shiftModel = Mockito.mock(ShiftModel.class);
        loginModel = Mockito.mock(LoginModel.class);
        when(loginModel.getCurrentUserId()).thenReturn(1);

        List<Shift> allShifts = new ArrayList<>();
        allShifts.add(new Shift(1, 1, LocalDate.now(), "09:00", "17:00"));
        allShifts.add(new Shift(2, 1, LocalDate.now().plusDays(1), "09:00", "17:00"));
        allShifts.add(new Shift(3, 1, LocalDate.now().minusDays(1), "09:00", "17:00"));

        when(shiftModel.viewAllShiftByUserID(anyInt())).thenReturn((ArrayList<Shift>) allShifts);

        employeeViewShiftModelTest = new EmployeeViewShiftViewModel(shiftModel, loginModel);
    }

    @Test
    public void test_GetShiftsToShow() {
        ObservableList<Shift> shiftsToShow = employeeViewShiftModelTest.getShiftsToShow();
        assertEquals(3, shiftsToShow.size());
    }

    @Test
    public void test_CheckIn() {
        int shiftID = 1;
        int userId = 1;
        employeeViewShiftModelTest.checkIn(shiftID, userId);
        verify(shiftModel, times(1)).checkIn(eq(shiftID), eq(userId));
    }

    @Test
    public void test_CheckOut() {
        int shiftID = 1;
        int userId = 1;
        employeeViewShiftModelTest.checkOut(shiftID, userId);
        verify(shiftModel, times(1)).checkOut(eq(shiftID), eq(userId));
    }

    @Test
    public void test_AllSelected() {
        employeeViewShiftModelTest.allSelected();
        ObservableList<Shift> shiftsToShow = employeeViewShiftModelTest.getShiftsToShow();
        assertEquals(3, shiftsToShow.size());
    }

    @Test
    public void test_UpcomingSelectedShift() {
        employeeViewShiftModelTest.upcomingSelected();
        ObservableList<Shift> shiftsToShow = employeeViewShiftModelTest.getShiftsToShow();
        assertEquals(2, shiftsToShow.size());
    }

    @Test
    public void test_PastSelectedShift() {
        employeeViewShiftModelTest.pastSelected();
        ObservableList<Shift> shiftsToShow = employeeViewShiftModelTest.getShiftsToShow();
        assertEquals(1, shiftsToShow.size());
    }

    @Test
    public void test_Calculate_TotalHours() {
        employeeViewShiftModelTest.calculateTotalHours();
        StringProperty totalHours = employeeViewShiftModelTest.getTotalHours();
        assertEquals("24", totalHours.get());
    }


}
