package EmployeeManagementSystem.client.view.LeaveRequestView;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.model.LeaveRequest;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;

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
        private Button approveButton;
        @FXML
        private Button rejectButton;
        @FXML
        private Button backButton;


        @FXML
        void approveClick(ActionEvent event)
        {
            LeaveRequest request=leaveRequestTable.;
        }

        @FXML
        void backbtnClick(ActionEvent event) {

        }

        @FXML
        void rejectClick(ActionEvent event) {

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
