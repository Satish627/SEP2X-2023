package EmployeeManagementSystem.client.view.AdminViews.ViewAllEmployees;

import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModel;
import EmployeeManagementSystem.client.model.EmployeeModel.EmployeeModelImpl;
import EmployeeManagementSystem.client.networking.EmployeeClient.EmployeeClient;
import EmployeeManagementSystem.shared.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.stubbing.OngoingStubbing;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ViewAllEmployeesViewModelTest
{
    private ViewAllEmployeesViewModel viewAllEmployeesViewModelTest;
    private EmployeeModel employeeModelTest;

//    @BeforeEach
//    void setUp()
//    {
//        EmployeeModelImpl employeeModelTest = mock(EmployeeModelImpl.class);
//        viewAllEmployeesViewModelTest = new ViewAllEmployeesViewModel(employeeModelTest);
//
//    }
@BeforeEach
void setUp() {
//    EmployeeClient employeeClientMock = Mockito.mock(EmployeeClient.class);
    employeeModelTest = Mockito.mock(EmployeeModel.class);
    viewAllEmployeesViewModelTest = new ViewAllEmployeesViewModel(employeeModelTest);
}


    @Test
    void test_ViewAllEmployee() {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        List<Employee> expectedEmployees = Arrays.asList(employee1, employee2);
        ObservableList<Employee> expectedEmployeeList = FXCollections.observableArrayList(expectedEmployees);
       when(employeeModelTest.viewAllEmployees()).thenReturn(new ArrayList<>(expectedEmployees));

        ObservableList<Employee> result = viewAllEmployeesViewModelTest.viewAllEmployees();

        assertEquals(expectedEmployees, result);
        verify(employeeModelTest).viewAllEmployees();
    }


    @Test
    void test_AddEmployee() throws SQLException, RemoteException {
        // Arrange
        String firstName = "Rohit";
        String lastName = "Pandey";
        String newPassword = "rohitpandey";
        int userId = 34;
        String email = "rohit@gmail.com";
        String address = "Horsens";
        int phoneNumber = 9089898;
        String dateOfBirth = "1991";

        when(employeeModelTest.addEmployee(firstName, lastName, newPassword, userId, email, address, phoneNumber, dateOfBirth))
                .thenReturn("success");

        viewAllEmployeesViewModelTest.getFirstName().set(firstName);
        viewAllEmployeesViewModelTest.getLastName().set(lastName);
        viewAllEmployeesViewModelTest.getUserId().set(userId);
        viewAllEmployeesViewModelTest.getEmail().set(email);
        viewAllEmployeesViewModelTest.getAddress().set(address);
        viewAllEmployeesViewModelTest.getPhNumber().set(phoneNumber);
        viewAllEmployeesViewModelTest.getDateOfBirth().set(dateOfBirth);

        // Act
        String result = employeeModelTest.addEmployee(firstName,lastName,newPassword,userId,email,address,phoneNumber,dateOfBirth);

        // Assert
        assertEquals("success", result);
        System.out.println("Employee added successfully.");
        verify(employeeModelTest).addEmployee(firstName, lastName, newPassword, userId, email, address, phoneNumber, dateOfBirth);
    }

    @Test
    public void test_missingEmployeeFirstName()
    {

        viewAllEmployeesViewModelTest.getFirstName().set(null);
        viewAllEmployeesViewModelTest.getLastName().set("");
        viewAllEmployeesViewModelTest.getAddress().set("");
        viewAllEmployeesViewModelTest.getEmail().set("");
        viewAllEmployeesViewModelTest.getPhNumber().set(0);
        viewAllEmployeesViewModelTest.getDateOfBirth().set("");


        String result = viewAllEmployeesViewModelTest.addEmployee();
        assertNull(result);


    }
}