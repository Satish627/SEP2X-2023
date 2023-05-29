package EmployeeViews.EmployeeLeaveRequestPage;

import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModel;
import EmployeeManagementSystem.client.view.EmployeeViews.EmployeeLeaveRequestPage.EmployeeLeaveRequestViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.rmi.RemoteException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeLeaveRequestViewModelTest {
    @Mock
    private LeaveRequestModel leaveRequestModel;

    private EmployeeLeaveRequestViewModel viewModel;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        viewModel = new EmployeeLeaveRequestViewModel(leaveRequestModel);
    }

    @Test
    public void testRequestLeaveSuccess() throws SQLException, RemoteException {
        // Set up test data
        int shiftID = 1;
        String reason = "Vacation";

        // Set up expectations
        viewModel.getShiftID().set(shiftID);
        viewModel.getReason().set(reason);

        // Call the method under test
        try {
            viewModel.requestLeave();
        } catch (Exception e) {
            // Exception handling if required
        }

        // Verify that the leave request was sent
        verify(leaveRequestModel).requestLeave(shiftID, reason);
    }

    @Test
    public void testRequestLeaveIncompleteData() throws SQLException, RemoteException {
        // Set up test data
        int shiftID = 0;
        String reason = "";

        // Set up expectations
        viewModel.getShiftID().set(shiftID);
        viewModel.getReason().set(reason);

        // Call the method under test
        try {
            viewModel.requestLeave();
        } catch (Exception e) {
            // Exception handling if required
        }

        // Verify that the leave request was not sent
        verify(leaveRequestModel, never()).requestLeave(anyInt(), anyString());
    }

    @Test
    public void testRequestLeaveIncompleteReason() throws SQLException, RemoteException {
        // Set up test data
        int shiftID = 1;
        String reason = null;

        // Set up expectations
        viewModel.getShiftID().set(shiftID);
        viewModel.getReason().set(reason);

        // Call the method under test
        try {
            viewModel.requestLeave();
        } catch (Exception e) {
            // Exception handling if required
        }

        // Verify that the leave request was not sent
        verify(leaveRequestModel, never()).requestLeave(anyInt(), anyString());
    }
}