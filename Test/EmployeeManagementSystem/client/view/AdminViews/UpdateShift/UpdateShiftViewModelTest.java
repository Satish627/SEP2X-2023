package EmployeeManagementSystem.client.view.AdminViews.UpdateShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateShiftViewModelTest {

    private ShiftModel shiftModel;
    private UpdateShiftViewModel viewModel;

    @BeforeEach
    public void setUp() {
        shiftModel = Mockito.mock(ShiftModel.class);
        Shift selectedShift = new Shift(1);
        selectedShift.setDate(LocalDate.of(2023, 5, 29));
        selectedShift.setCheckInTime("09:00 AM");
        selectedShift.setCheckOutTime("05:00 PM");
        when(shiftModel.getSelectedShift()).thenReturn(selectedShift);

        viewModel = new UpdateShiftViewModel(shiftModel);
    }



    @Test
    public void test_updateShift() {
        Shift selectedShift = new Shift(9);
        selectedShift.setDate(LocalDate.of(2023, 5, 29));

        when(shiftModel.getSelectedShift()).thenReturn(selectedShift);

        viewModel.getStartTime().set("10:00 AM");
        viewModel.getEndTime().set("02:00 PM");
        viewModel.getShiftDate().set(LocalDate.of(2023, 5, 30));

        viewModel.updateShift();

        verify(shiftModel, times(1)).updateShift(any(Shift.class));
    }
}
