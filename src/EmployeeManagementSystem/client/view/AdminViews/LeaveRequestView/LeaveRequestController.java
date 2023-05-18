package EmployeeManagementSystem.client.view.AdminViews.LeaveRequestView;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;

public class LeaveRequestController implements ViewController {
        private ViewHandler viewHandler;
        private LeaveRequestViewModel leaveRequestViewModel;

        @FXML
        private TableView<LeaveRequest>leaveRequestTable;
        @FXML
        private TableColumn<LeaveRequest,Integer> shiftIDCol;
        @FXML
        private TableColumn<LeaveRequest,String> reasonCol;


        @FXML
        void approveClick(ActionEvent event)
        {

            int shiftID = leaveRequestTable.getSelectionModel().getSelectedItem().getShiftID();
            System.out.println(shiftID);
            try {
                leaveRequestViewModel.approveLeave(shiftID);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @FXML
        void backbtnClick(ActionEvent event) {
            viewHandler.backPage();
        }

        @FXML
        void rejectClick(ActionEvent event) {
            int shiftID=leaveRequestTable.getSelectionModel().getSelectedItem().getShiftID();
            try {
                leaveRequestViewModel.rejectLeave(shiftID);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }



    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler=viewHandler;
        leaveRequestViewModel=viewModelFactory.getLeaveRequestViewModel();
        initializeTableView();
    }

    private void initializeTableView()
    {
        shiftIDCol.setCellValueFactory(new PropertyValueFactory<>("shiftID"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));
        leaveRequestTable.setItems(leaveRequestViewModel.viewAllLeaveRequests());
    }


}
