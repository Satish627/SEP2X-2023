package EmployeeManagementSystem.client.view.AdminViews.LeaveRequestView;

import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModel;
import EmployeeManagementSystem.client.model.LeaveRequestModel.LeaveRequestModelImpl;
import EmployeeManagementSystem.client.networking.LeaveRequestClient.LeaveRequestClient;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LeaveRequestViewModelTest
{
    private LeaveRequestViewModel leaveRequestViewModelTest;
    private LeaveRequestModelImpl leaveRequestModelTest;
    private LeaveRequestClient leaveRequestClientTest;
    private LeaveRequest leaveRequest;

    @BeforeEach
    void setUp()
    {
        leaveRequestModelTest = mock(LeaveRequestModelImpl.class);
        leaveRequestViewModelTest = new LeaveRequestViewModel(leaveRequestModelTest);

    }
    @Test
    public void test_ApproveLeave_by_ShiftID() throws RemoteException
    {
        // Arrange
        int shiftID = 123;

        // Act
        leaveRequestViewModelTest.approveLeave(shiftID);

        // Assert
        verify(leaveRequestModelTest).approveLeave(shiftID);
    }
    @Test
    public void test_RejectLeave_by_ShiftID() throws RemoteException
    {
        // Arrange
        int shiftID = 0;

        // Act
        leaveRequestViewModelTest.rejectLeave(shiftID);

        // Assert
        verify(leaveRequestModelTest).rejectLeave(shiftID);
    }
    @Test
    public void testViewAllLeaveRequests() throws RemoteException
    {
        // Arrange
        List<LeaveRequest> expectedLeaveRequests = new ArrayList<>();
        expectedLeaveRequests.add(new LeaveRequest(leaveRequest.getShiftID(), leaveRequest.getReason()));
        expectedLeaveRequests.add(new LeaveRequest(leaveRequest.getShiftID(), leaveRequest.getReason()));


        when(leaveRequestModelTest.viewAllLeaveRequests()).thenReturn(new ArrayList<>(expectedLeaveRequests));

        // Act
        ObservableList<LeaveRequest> result = leaveRequestViewModelTest.viewAllLeaveRequests();

        // Assert
        assertIterableEquals(expectedLeaveRequests, result);
    }

}