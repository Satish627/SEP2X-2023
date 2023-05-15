package EmployeeManagementSystem.client.view.AdminViews.MainView;


import javafx.event.ActionEvent;
import javafx.scene.control.*;


import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.fxml.FXML;

public class MainController implements ViewController {
    private ViewHandler viewHandler;
    private MainViewModel mainViewModel;



    @FXML
    private MenuItem employeeListBtn;
    @FXML
    private MenuItem logOutSystem;

    @FXML
    void viewEmployeeLink(ActionEvent event)
    {
        viewHandler.openViewAllEmployeesView();

    }

        @FXML
        void ViewShiftLink(ActionEvent event)
        {
            viewHandler.openViewShift();

        }

        @FXML
        void leaveRequestLink(ActionEvent event)
        {
            viewHandler.leaveRequest();

        }

    @FXML
    void addEmployeeLink(ActionEvent event)
    {
        viewHandler.addEmployeeBtn();

    }

    @FXML
    void menuBar(ActionEvent event)
    {
        if(event.getSource() ==employeeListBtn)
        {
            viewHandler.openViewAllEmployeesView();
        }
        if(event.getSource() == logOutSystem)
        {
            Alert exit = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure want to logOut from this system?",
            ButtonType.YES , ButtonType.NO);
            exit.setTitle("LogOut");
            exit.setHeaderText(null);

            exit.showAndWait();
            if(exit.getResult() == ButtonType.YES)
            {
                System.exit(1);
            }

        }

    }






//    @FXML
//    void viewEmployeeLink(ActionEvent event)
//    {
//        viewHandler.openViewAllEmployeesView();
//    }
//
//    @FXML
//    void ViewShiftLink(ActionEvent event)
//    {
//        openViewShift();
//    }
//
//    private void openViewShift() {
//        viewHandler.openViewShift();
//    }
//
//    @FXML
//    void leaveRequestLink(ActionEvent event)
//    {
//        leaveRequest();
//
//    }

    private void leaveRequest()
    {
        viewHandler.leaveRequest();
    }

    public void openEmployeeViewShift(){
        viewHandler.openEmployeeViewShifts();
    }



    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        mainViewModel = viewModelFactory.getMainViewModel();

    }


}
