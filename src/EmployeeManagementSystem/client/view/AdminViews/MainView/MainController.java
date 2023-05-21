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
    private Label welcomeMessage;
    @FXML
    private MenuItem employeeListBtn;
    @FXML
    private MenuItem logOutSystem;
    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        mainViewModel = viewModelFactory.getMainViewModel();
    }
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
    void addShiftLink(ActionEvent event)
    {
        viewHandler.openAddShiftView();

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
}
