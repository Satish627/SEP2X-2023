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

    private Scene loginScene, mainScene;

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
            Parent root = loadFXMLFile("../view/MainView/Main.fxml");
            mainScene = new Scene(root);
            stage.setTitle("Main view ma ayo..");
        }
        stage.setScene(mainScene);
        stage.show();
    }
}

