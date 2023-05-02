package EmployeeManagementSystem.client.view.ViewAllEmployees;

import EmployeeManagementSystem.client.model.Employee.EmployeeModel;
import EmployeeManagementSystem.client.model.Employee.EmployeeModelImpl;
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
