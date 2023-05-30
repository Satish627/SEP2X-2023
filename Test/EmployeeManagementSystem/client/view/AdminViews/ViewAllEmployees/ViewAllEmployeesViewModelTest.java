package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees.ViewAllEmployeesViewModel;
import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.shared.model.Employee;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ViewAllEmployeesViewModelTest {
    private ViewAllEmployeesViewModel viewAllEmployeesViewModelTest;


    @Mock
    private EmployeeModel employeeModelTest;

    @BeforeEach
    void setUp()
    {
        employeeModelTest = Mockito.mock(EmployeeModel.class);
        viewAllEmployeesViewModelTest = new ViewAllEmployeesViewModel(employeeModelTest);
    }
    @Test
    void test_EditEmployee() {
        // Set up mock data
        int userId = 1;
        String firstName = "Apurva";
        String lastName = "Shrestha";
        String password = "apurva123";
        String dateOfBirth = "2001-05-15";
        String address = "Kathmandu";
        int phoneNumber = 1234567890;
        String email = "apu@example.com";

        viewAllEmployeesViewModelTest.editEmployee(userId, firstName, lastName, password, dateOfBirth, address, phoneNumber, email);
        verify(employeeModelTest).updateEmployee(userId, firstName, lastName, password, dateOfBirth, address, phoneNumber, email);


    }


    @Test
    void test_DeleteEmployee()
    {

        int userId = 1;
        viewAllEmployeesViewModelTest.deleteEmployee(userId);
        verify(employeeModelTest).deleteEmployee(userId);
    }


    @Test
    void test_UpdateEmployee()
    {
        Employee employee = new Employee(1, "John", "Doe", "1990-05-15", "123 Main St", 1234567890, "john@example.com");

        viewAllEmployeesViewModelTest.editEmployee(
                employee.getUserId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPassword(),
                employee.getDateOfBirth(),
                employee.getAddress(),
                employee.getPhoneNumber(),
                employee.getEmail()
        );

        verify(employeeModelTest, times(1)).updateEmployee(
                eq(employee.getUserId()),     //eq (equals) is used to match the expected values of the employee's properties when verifying the updateEmployee method call.
                eq(employee.getFirstName()),
                eq(employee.getLastName()),
                eq(employee.getPassword()),
                eq(employee.getDateOfBirth()),
                eq(employee.getAddress()),
                eq(employee.getPhoneNumber()),
                eq(employee.getEmail())
        );
    }

//    @Test
//    void test_newEmployeeAdded()
//    {
//
//    }

    }



