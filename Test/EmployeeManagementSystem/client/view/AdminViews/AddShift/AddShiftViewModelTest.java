package EmployeeManagementSystem.client.view.AdminViews.AddShift;
import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddShiftViewModelTest {

    private AddShiftViewModel addShiftViewModel;

    @Mock
    private ShiftModel shiftModel;

    private Integer shiftID;
    private Integer employeeID;
    private String startTime;
    private String endTime;
    private String employeeName;
    private ObjectProperty<LocalDate> date;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        shiftID = 1;
        employeeID = 1;
        startTime = "09:00";
        endTime = "17:00";
        employeeName = "John Doe";
        date = new SimpleObjectProperty<>(LocalDate.now());

        addShiftViewModel = new AddShiftViewModel(shiftModel);
        addShiftViewModel.getShiftID().set(shiftID);
        addShiftViewModel.getEmployeeID().set(employeeID);
        addShiftViewModel.getEmployeeName().set(employeeName);
        addShiftViewModel.getDate().bindBidirectional(date);
        addShiftViewModel.getStartTime().set(startTime);
        addShiftViewModel.getEndTime().set(endTime);
    }

    @Test
    public void testAddShift_Successful() {
        Shift expectedShift = new Shift(shiftID, employeeID, date.get(), startTime, endTime, employeeName);
        when(shiftModel.addShift(employeeID, date.get(), startTime, endTime)).thenReturn(expectedShift);

        Shift resultShift = addShiftViewModel.addShift();

        assertNotNull(resultShift);
        assertEquals(expectedShift, resultShift);
        verify(shiftModel, times(1)).addShift(employeeID, date.get(), startTime, endTime);
    }

    @Test
    public void testAddShift_MissingInformation() {
        addShiftViewModel.getEmployeeID().set(0);

        Shift resultShift = addShiftViewModel.addShift();

        assertNull(resultShift);
        verify(shiftModel, never()).addShift(anyInt(), any(LocalDate.class), anyString(), anyString());
    }
}