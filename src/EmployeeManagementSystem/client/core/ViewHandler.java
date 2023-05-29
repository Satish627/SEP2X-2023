package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private final ViewModelFactory viewModelFactory;

    private Scene loginScene, adminLoginScene,mainScene,employeeScene, addEmployeeScene,updateShiftScene, editEmployeeScene, viewShiftScene,
            leaveRequestScene,addShiftScene,employeeShiftViewScene, employeeRequestPageScene;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }



    public void start(){
        stage = new Stage();
        openLoginView();
    }

    private Parent loadFXMLFile(String path) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(path));
            Parent root = null;
            try{
                root= loader.load();
            }
            catch(IOException e){
                e.printStackTrace();
        }
            ViewController ctrl = loader.getController();
            ctrl.init(this,viewModelFactory);
                    return root;
    }
    public void openLoginView() {
            if(loginScene == null){
                Parent root = loadFXMLFile("../view/LoginView/EmployeeLogin/EmployeeLogin.fxml");
                loginScene = new Scene(root);
                stage.setTitle("Login to get access");
            }
            stage.setScene(loginScene);
            stage.show();
    }
    public void openAdminLoginView() {
        if(adminLoginScene == null){
            Parent root = loadFXMLFile("../view/LoginView/AdminLogin/AdminLogin.fxml");
            adminLoginScene = new Scene(root);
            stage.setTitle("Admin login");
        }
        stage.setScene(adminLoginScene);
        stage.show();
    }
    public void openMainView() {
        if(mainScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/MainView/Main.fxml");
            mainScene = new Scene(root);
            stage.setTitle("Main view");
        }
        stage.setScene(mainScene);
        stage.show();
    }

    public void openViewAllEmployeesView()
    {
        if(employeeScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/ViewAllEmployees/ViewAllEmployees.fxml");
            employeeScene = new Scene(root);
            stage.setTitle("Employee List");
        }
        stage.setScene(employeeScene);
        stage.show();
    }

    public void openEmployeeViewShifts() {
        if(employeeShiftViewScene == null)
        {
            Parent root = loadFXMLFile("../view/EmployeeViews/ViewShift/EmployeeViewShift.fxml");
            employeeShiftViewScene = new Scene(root);
            stage.setTitle("Welcome to Employee Shifts");

        }

        stage.setScene(employeeShiftViewScene);
        stage.show();

    }

    public void openEmployeeLeaveRequestPage() {

        if(employeeRequestPageScene == null)
        {
            Parent root = loadFXMLFile("../view/EmployeeViews/EmployeeLeaveRequestPage/EmployeeLeaveRequest.fxml");
            employeeRequestPageScene = new Scene(root);
            stage.setTitle("Kindly make your leave request here..");
        }
        stage.setScene(employeeRequestPageScene);
        stage.show();
    }


    public void backPage()
    {
        if(mainScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/MainView/Main.fxml");
            mainScene = new Scene(root);
            stage.setTitle("Main view ");
        }
        stage.setScene(mainScene);
        stage.show();
    }

    public void openBackPage()
    {
        {
            if(employeeScene== null){
                Parent root = loadFXMLFile("../view/AdminViews/ViewAllEmployees/ViewAllEmployees.fxml");
                employeeScene = new Scene(root);
                stage.setTitle("Employee view");
            }
            stage.setScene(employeeScene);
            stage.show();
        }

    }

    public void openViewShift() {

        if(viewShiftScene == null)
        {
            Parent root = loadFXMLFile("../view/AdminViews/ViewShift/ViewShift.fxml");
            viewShiftScene = new Scene(root);
            stage.setTitle("Welcome to View Shift");

        }
        stage.setScene(viewShiftScene);
        stage.show();

    }
    public void leaveRequest()
    {
        if(leaveRequestScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/LeaveRequestView/LeaveRequest.fxml");
            leaveRequestScene = new Scene(root);
            stage.setTitle("Leave Request View");
        }
        stage.setScene(leaveRequestScene);
        stage.show();
    }

    public void openAddShiftView()
    {
        if(addShiftScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/AddShift/AddShift.fxml");
            addShiftScene = new Scene(root);
            stage.setTitle("Add Shift View");
        }
        stage.setScene(addShiftScene);
        stage.show();
    }

    public void openEditEmployeeView()
    {
        if(editEmployeeScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/EditEmployee/EditEmployee.fxml");
            editEmployeeScene = new Scene(root);
            stage.setTitle("Edit Employee");
        }
        stage.setScene(editEmployeeScene);
        stage.show();
    }

    public void EmployeeBackPage()
    {
        if (employeeShiftViewScene == null) {
            Parent root=loadFXMLFile("../view/EmployeeViews/ViewShift/EmployeeViewShift.fxml");
            employeeShiftViewScene = new Scene(root);
        }
        stage.setScene(employeeShiftViewScene);
        stage.show();
    }

    public void openUpdateShift() {
        if (updateShiftScene == null) {
            Parent root=loadFXMLFile("../view/AdminViews/UpdateShift/UpdateShift.fxml");
            updateShiftScene = new Scene(root);
        }
        stage.setScene(updateShiftScene);
        stage.show();

    }

    public void openAddEmployeeView() {
        if (addEmployeeScene == null) {
            Parent root=loadFXMLFile("../view/AdminViews/AddEmployee/AddEmployee.fxml");
            addEmployeeScene = new Scene(root);
        }
        stage.setScene(addEmployeeScene);
        stage.show();
    }
}

    





