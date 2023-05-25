package Login;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import EmployeeManagementSystem.client.view.LoginView.EmployeeLogin.EmployeeLoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.shared.model.Employee;

class EmployeeLoginViewModelTest {

    @Mock
    private LoginModel mockLoginModel;

    private EmployeeLoginViewModel viewModel;

    @BeforeEach
    void setUp() {
        mockLoginModel= Mockito.mock(LoginModel.class);
        viewModel = new EmployeeLoginViewModel(mockLoginModel);
    }

    @Test
    void testLogin_InvalidCredentials() {
        viewModel.getId().set(0);
        viewModel.getPasswd().set(null);

        Employee result = viewModel.login();

        assertNull(result);
        assertEquals("Please enter your employee id and password ", viewModel.getMessage().get());
    }

    @Test
    void testLogin_MissingId() {
        viewModel.getId().set(0);
        viewModel.getPasswd().set("password");

        Employee result = viewModel.login();

        assertNull(result);
        assertEquals("Please enter your employee id", viewModel.getMessage().get());
    }

    @Test
    void testLogin_MissingPassword() {
        viewModel.getId().set(1);
        viewModel.getPasswd().set(null);

        Employee result = viewModel.login();

        assertNull(result);
        assertEquals("Please enter your password ", viewModel.getMessage().get());
    }

    @Test
    void testLogin_ValidCredentials() {
        int userId = 1;
        String password = "password";
        Employee expectedEmployee = new Employee(userId, password);

        viewModel.getId().set(userId);
        viewModel.getPasswd().set(password);

        when(mockLoginModel.login(userId, password)).thenReturn(expectedEmployee);

        Employee result = viewModel.login();

        verify(mockLoginModel).login(userId, password);
        assertEquals(expectedEmployee, result);
        assertEquals("Tried to login", viewModel.getMessage().get());
    }
}