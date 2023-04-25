package EmployeeManagementSystem.client;

import EmployeeManagementSystem.client.core.ClientFactory;
import EmployeeManagementSystem.client.core.ModelFactory;
import EmployeeManagementSystem.client.core.ViewHandler;
import EmployeeManagementSystem.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private ViewHandler vh;
    private ViewModelFactory vmf;
    private ModelFactory mf;
    private ClientFactory cf;

    @Override
    public void start(Stage stage) throws Exception {
        cf = new ClientFactory();
        mf = new ModelFactory(cf);
        vmf = new ViewModelFactory(mf);
        vh= new ViewHandler(stage,vmf);
        vh.start();


    }
}
