package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import EmployeeManagementSystem.client.view.ViewController;
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



public class ViewAllEmployeesController implements ViewController
{
    @FXML
    private MenuItem addShiftBtn;
    @FXML
    private TableView<Employee> employeeList;
    @FXML private TableColumn<Employee, Integer> userId;
    @FXML private TableColumn<Employee, String> firstName;
    @FXML private TableColumn<Employee, String> lastName;
    @FXML private TableColumn<Employee, String> dateOfBirth;
    @FXML private TableColumn<Employee, String> address;
    @FXML private TableColumn<Employee, Integer> phoneNumber;
    @FXML private TableColumn<Employee, String> email;
    private ViewHandler viewHandler;
    private ViewAllEmployeesViewModel viewAllEmployeesViewModel;

    @FXML private TextField fname;
  @FXML private TextField  lname;
    @FXML private TextField  uId;
    @FXML private TextField  dob;
    @FXML private TextField  Address;
    @FXML private TextField  pNum;
    @FXML private TextField  Email;
    @FXML private TextField search;
    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        viewAllEmployeesViewModel = viewModelFactory.getEmployeeViewModel();
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
        employeeList.setItems(viewAllEmployeesViewModel.viewAllEmployees());
        SearchBar();
    }
    private void bindTextFieldValues() throws RuntimeException{
       uId.textProperty().bindBidirectional(viewAllEmployeesViewModel.getUserId(), new NumberStringConverter());
        fname.textProperty().bindBidirectional(viewAllEmployeesViewModel.getFirstName());
        lname.textProperty().bindBidirectional(viewAllEmployeesViewModel.getLastName());
        dob.textProperty().bindBidirectional(viewAllEmployeesViewModel.getDateOfBirth());
        Address.textProperty().bindBidirectional(viewAllEmployeesViewModel.getAddress());
        pNum.textProperty().bindBidirectional(viewAllEmployeesViewModel.getPhNumber(), new NumberStringConverter());
        Email.textProperty().bindBidirectional(viewAllEmployeesViewModel.getEmail());

    }
    public void SearchBar() {
        FilteredList<Employee> filteredList = new FilteredList<>(employeeList.getItems());
        search.textProperty().addListener((observable,oldValue,newValue )->{
            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()|| newValue.isBlank()){
                    return true; //return all users  if the field is empty
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if ((String.valueOf(employee.getUserId()).contains(lowerCaseFilter))){
                    return true;
                }else if (employee.getFirstName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if (employee.getLastName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if (employee.getDateOfBirth().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if (employee.getAddress().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if (String.valueOf(employee.getPhoneNumber()).contains(lowerCaseFilter)){
                    return true;
                }
                else if (employee.getEmail().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else {
                    return false;
                }
            });
        });
        //Using sortedList to wrap the filteredlist
        SortedList<Employee> sortedList = new SortedList<>(filteredList);
        //Binding sortedList to TableView to have effects.
        sortedList.comparatorProperty().bind( employeeList.comparatorProperty());
        //add sorted data to the table
        employeeList.setItems(sortedList);
    }

    @FXML
    void addShiftClick(ActionEvent event)
    {
        viewHandler.openAddShiftView();
    }

    @FXML
    void menuBarClick(ActionEvent event) {
        if (event.getSource() == addShiftBtn) {
            viewHandler.openAddShiftView();
        }}

@FXML
void getSelectedItem(MouseEvent mouseEvent) {
    int index = employeeList.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        uId.setText(userId.getCellData(index).toString());
    fname.setText(firstName.getCellData(index));
    lname.setText(lastName.getCellData(index));
    dob.setText(dateOfBirth.getCellData(index));
    Address.setText(address.getCellData(index));
    pNum.setText(phoneNumber.getCellData(index).toString());
    Email.setText(email.getCellData(index));
}

    @FXML
    public void onRemoveEmployeeButtonClick(ActionEvent event) {
        viewAllEmployeesViewModel.deleteEmployee(Integer.parseInt(uId.getText()));
        clearTextInputs();
    }

   @FXML public void onAddEmployeeButtonClick(ActionEvent event) {
        viewAllEmployeesViewModel.addEmployee();
        clearTextInputs();
    }
    @FXML
    void onEditEmployeeButtonClick(ActionEvent event) {
        viewAllEmployeesViewModel.editEmployee(Integer.parseInt(uId.getText()),fname.getText(),lname.getText(),dob.getText(),Address.getText(),Integer.parseInt(pNum.getText()),Email.getText());
        clearTextInputs();
    }

   @FXML
   public void onBackButtonClick(ActionEvent event) {
        viewHandler.backPage();
    }
    private void clearTextInputs() {
        fname.setText(null);
        lname.setText(null);
        Email.setText(null);
        uId.setText(null);
        Address.setText(null);
        pNum.setText(null);
        dob.setText(null);
    }

}
