package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.shared.model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ViewAllEmployeesViewModel {
    private EmployeeModel employeeModel;
    private ObservableList<Users> employeeList;
    public ViewAllEmployeesViewModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
        employeeList = FXCollections.observableList(employeeModel.viewAllEmployees());

    }

    public ObservableList<Users> viewAllEmployees() {
        return employeeList;
    }
}
