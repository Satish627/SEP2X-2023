package EmployeeManagementSystem.client.view.AdminViews.AddEmployee;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;

public class AddEmployeeController implements ViewController {
    @FXML
    private MenuItem addShiftBtn;
    @FXML
    private TableView<Employee> employeeList;
    @FXML
    private TableColumn<Employee, Integer> userId;
    @FXML
    private TableColumn<Employee, String> firstName;
    @FXML
    private TableColumn<Employee, String> lastName;
    @FXML
    private TableColumn<Employee, String> dateOfBirth;
    @FXML
    private TableColumn<Employee, String> address;
    @FXML
    private TableColumn<Employee, Integer> phoneNumber;
    @FXML
    private TableColumn<Employee, String> email;
    private ViewHandler viewHandler;
    private AddEmployeeViewModel addEmployeeViewModel;

    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField Address;
    @FXML
    private TextField pNum;
    @FXML
    private TextField Email;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        addEmployeeViewModel = viewModelFactory.getAddEmployeeViewModel();
        initialiseTableView();
        bindTextFieldValues();
    }

    private void initialiseTableView() {
        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        employeeList.setItems(addEmployeeViewModel.viewAllEmployees());
    }

    private void bindTextFieldValues() throws RuntimeException {
        String regex = "[0-9]*";

        // Create a TextFormatter with a filter that allows only numbers
        TextFormatter<String> employeeIdTextFormatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches(regex)) {
                return change;
            }
            return null;
        });
        pNum.setTextFormatter(employeeIdTextFormatter);
        fname.textProperty().bindBidirectional(addEmployeeViewModel.getFirstName());
        lname.textProperty().bindBidirectional(addEmployeeViewModel.getLastName());
        dob.valueProperty().bindBidirectional(addEmployeeViewModel.getDateOfBirth());
        Address.textProperty().bindBidirectional(addEmployeeViewModel.getAddress());
        pNum.textProperty().bindBidirectional(addEmployeeViewModel.getPhNumber());
        Email.textProperty().bindBidirectional(addEmployeeViewModel.getEmail());

    }

    @FXML
    void menuBarClick(ActionEvent event) {
        if (event.getSource() == addShiftBtn) {
            viewHandler.openAddShiftView();
        }
    }

    @FXML public void onAddEmployeeButtonClick(ActionEvent event) {
        try {
           addEmployeeViewModel.addEmployee();
            AlertBox.showAlert("Employee added successfully");
        } catch (Exception e) {
            AlertBox.showAlert(e.getMessage());
        }
        clearTextInputs();
    }

    private void clearTextInputs() {
        fname.setText(null);
        lname.setText(null);
        Email.setText(null);
        Address.setText(null);
        pNum.setText(null);
        //dob.setAccessibleText(null);
    }


    public void onBackButtonClick(ActionEvent event) {
        viewHandler.openMainView();
    }
}
