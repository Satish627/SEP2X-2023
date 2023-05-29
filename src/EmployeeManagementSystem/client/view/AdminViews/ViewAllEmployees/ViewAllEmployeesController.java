package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
import EmployeeManagementSystem.shared.AlertBox;
import EmployeeManagementSystem.shared.model.Employee;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ViewAllEmployeesController implements ViewController {
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
    private TableColumn<Employee, String> password;

    @FXML
    private TableColumn<Employee, String> dateOfBirth;
    @FXML
    private TableColumn<Employee, String> address;
    @FXML
    private TableColumn<Employee, Integer> phoneNumber;
    @FXML
    private TableColumn<Employee, String> email;
    private ViewHandler viewHandler;
    private ViewAllEmployeesViewModel viewAllEmployeesViewModel;

    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField passwd;

    @FXML
    private DatePicker dob;
    @FXML
    private TextField Address;
    @FXML
    private TextField pNum;
    @FXML
    private TextField Email;
    @FXML
    private TextField search;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        viewAllEmployeesViewModel = viewModelFactory.getEmployeeViewModel();
        initialiseTableView();
        bindTextFieldValues();
    }

    private void initialiseTableView() {


        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        employeeList.setItems(viewAllEmployeesViewModel.viewAllEmployees());
        SearchBar();
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
        fname.textProperty().bindBidirectional(viewAllEmployeesViewModel.getFirstName());
        lname.textProperty().bindBidirectional(viewAllEmployeesViewModel.getLastName());
        passwd.textProperty().bindBidirectional(viewAllEmployeesViewModel.getPassword());
        dob.valueProperty().bindBidirectional(viewAllEmployeesViewModel.getDateOfBirth());
        Address.textProperty().bindBidirectional(viewAllEmployeesViewModel.getAddress());
        pNum.textProperty().bindBidirectional(viewAllEmployeesViewModel.getPhNumber());
        Email.textProperty().bindBidirectional(viewAllEmployeesViewModel.getEmail());

    }

    public void SearchBar() {
        FilteredList<Employee> filteredList = new FilteredList<>(employeeList.getItems());
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true; //return all users  if the field is empty
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if ((String.valueOf(employee.getUserId()).contains(lowerCaseFilter))) {
                    return true;
                } else if (employee.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (employee.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (employee.getDateOfBirth().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (employee.getAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(employee.getPhoneNumber()).contains(lowerCaseFilter)) {
                    return true;
                } else if (employee.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        //Using sortedList to wrap the filteredlist
        SortedList<Employee> sortedList = new SortedList<>(filteredList);
        //Binding sortedList to TableView to have effects.
        sortedList.comparatorProperty().bind(employeeList.comparatorProperty());
        //add sorted data to the table
        employeeList.setItems(sortedList);
    }

    @FXML
    void addShiftClick(ActionEvent event) {
        viewHandler.openAddShiftView();
    }

    @FXML
    void menuBarClick(ActionEvent event) {
        if (event.getSource() == addShiftBtn) {
            viewHandler.openAddShiftView();
        }
    }

    @FXML
    void getSelectedItem(MouseEvent mouseEvent) {
        int index = employeeList.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        fname.setText(firstName.getCellData(index));
        lname.setText(lastName.getCellData(index));
        password.setText(password.getCellData(index));
        dob.setValue(stringToLocaleDate(dateOfBirth.getCellData(index)));
        Address.setText(address.getCellData(index));
        pNum.setText(phoneNumber.getCellData(index).toString());
        Email.setText(email.getCellData(index));
    }

    private LocalDate stringToLocaleDate(String cellData) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(cellData, formatter);
    }

    @FXML
    public void onRemoveEmployeeButtonClick(ActionEvent event) {
        try {
            Employee selectedItem = employeeList.getSelectionModel().getSelectedItem();
            if (selectedItem == null) AlertBox.showAlert("Select employee to remove");
            viewAllEmployeesViewModel.deleteEmployee(selectedItem.getUserId());
            AlertBox.showAlert("Selected employee deleted");
            clearTextInputs();
        } catch (Exception e) {
            AlertBox.showAlert(e.getMessage());
        }
    }

    @FXML
    void onEditEmployeeButtonClick(ActionEvent event) {
        Employee selectedItem = employeeList.getSelectionModel().getSelectedItem();
        if (selectedItem == null) AlertBox.showAlert("Select employee to update");
        viewAllEmployeesViewModel.editEmployee(selectedItem.getUserId(), fname.getText(), lname.getText(), passwd.getText(),  dateToString(dob.getValue()), Address.getText(), Integer.parseInt(pNum.getText()), Email.getText());
        clearTextInputs();
    }

    private String dateToString(LocalDate value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return value.format(formatter);
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) {
        viewHandler.backPage();
    }

    private void clearTextInputs() {
        fname.setText(null);
        lname.setText(null);
        Email.setText(null);
        Address.setText(null);
        pNum.setText(null);

    }

}
