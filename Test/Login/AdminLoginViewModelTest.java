package Login;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import EmployeeManagementSystem.client.view.LoginView.AdminLogin.AdminLoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import EmployeeManagementSystem.client.model.LoginModel.LoginModel;
import EmployeeManagementSystem.shared.model.Admin;

class AdminLoginViewModelTest {

    @Mock
    private LoginModel mockLoginModel;

    private AdminLoginViewModel viewModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewModel = new AdminLoginViewModel(mockLoginModel);
    }

    @Test
    void testAdminLogin_InvalidCredentials() {
        viewModel.getAdminId().set(0);
        viewModel.getAdminPW().set(null);

        Admin result = viewModel.adminLogin();

        assertNull(result);
        assertEquals("Please enter your user id and password ", viewModel.getMessageText().get());
    }

    @Test
    void testAdminLogin_MissingId() {
        viewModel.getAdminId().set(0);
        viewModel.getAdminPW().set("password");

        Admin result = viewModel.adminLogin();

        assertNull(result);
        assertEquals("Please enter your employee id", viewModel.getMessageText().get());
    }

    @Test
    void testAdminLogin_MissingPassword() {
        viewModel.getAdminId().set(1);
        viewModel.getAdminPW().set(null);

        Admin result = viewModel.adminLogin();

        assertNull(result);
        assertEquals("Please enter your password ", viewModel.getMessageText().get());
    }

    @Test
    void testAdminLogin_ValidCredentials() {
        int adminId = 1;
        String password = "password";
        Admin expectedAdmin = new Admin(adminId, password);

        viewModel.getAdminId().set(adminId);
        viewModel.getAdminPW().set(password);

        when(mockLoginModel.adminLogin(adminId, password)).thenReturn(expectedAdmin);

        Admin result = viewModel.adminLogin();

        verify(mockLoginModel).adminLogin(adminId, password);
        assertEquals(expectedAdmin, result);
        assertEquals("Tried to login", viewModel.getMessageText().get());
    }
}
