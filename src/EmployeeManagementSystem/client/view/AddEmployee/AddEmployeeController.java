package EmployeeManagementSystem.client.view.AddEmployee;
import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddEmployeeController implements ViewController
{
    private ViewHandler viewHandler;
    private AddEmployeeViewModel addEmployeeViewModel;

        @FXML
        void backClick(ActionEvent event)
        {
            openBackPage();
        }

    private void openBackPage()
    {
        viewHandler.openBackPage();
    }

    @FXML
        void cancelClick(ActionEvent event) {

        }

        @FXML
        void saveClick(ActionEvent event) {

        }

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        addEmployeeViewModel = viewModelFactory.getAddEmployeeViewModel();


    }
}

