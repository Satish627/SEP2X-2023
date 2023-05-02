package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private final ViewModelFactory viewModelFactory;

    private Scene loginScene, mainScene,employeeScene, addEmployeeScene, viewShiftScene,
            leaveRequestScene,addShiftScene;

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
    private void openLoginView() {
            if(loginScene == null){
                Parent root = loadFXMLFile("../view/LoginView/Login.fxml");
                loginScene = new Scene(root);
                stage.setTitle("Loginnn gara mero babu...");
            }
            stage.setScene(loginScene);
            stage.show();
    }

    public void openMainView() {
        if(mainScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/MainView/Main.fxml");
            mainScene = new Scene(root);
            stage.setTitle("Main view ma ayo..");
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


    public void backPage()
    {
        if(mainScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/MainView/Main.fxml");
            mainScene = new Scene(root);
            stage.setTitle("Main view ma jane feri..");
        }
        stage.setScene(mainScene);
        stage.show();
    }


    public void addEmployeeBtn()
    {
        if(addEmployeeScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/AddEmployee/AddEmployee.fxml");
            addEmployeeScene = new Scene(root);
            stage.setTitle("Add Employee");
        }
        stage.setScene(addEmployeeScene);
        stage.show();
    }

    public void openBackPage()
    {
        {
            if(employeeScene== null){
                Parent root = loadFXMLFile("../view/AdminViews/ViewAllEmployees.fxml");
                employeeScene = new Scene(root);
                stage.setTitle("Employee view ma jane feri..");
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
            Parent root = loadFXMLFile("../view/LeaveRequestView/LeaveRequest.fxml");
            leaveRequestScene = new Scene(root);
            stage.setTitle("Leave Request View");
        }
        stage.setScene(leaveRequestScene);
        stage.show();
    }

    public void openAddShift()
    {
        if(addShiftScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/AddShift/AddShift.fxml");
            addShiftScene = new Scene(root);
            stage.setTitle("Add Shift View");
        }
        stage.setScene(addShiftScene);
        stage.show();
    }


    public void openBackButton()
    {
        if(employeeScene == null){
            Parent root = loadFXMLFile("../view/AdminViews/ViewAllEmployees.fxml");
            employeeScene= new Scene(root);
            stage.setTitle("Employee view ma jane feri..");
        }
        stage.setScene(employeeScene);
        stage.show();
    }


}







