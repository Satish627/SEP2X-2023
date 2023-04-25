package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.model.Login.LoginModel;
import EmployeeManagementSystem.client.model.Login.LoginModelImpl;
import EmployeeManagementSystem.client.model.MainView.MainModelImpl;
import EmployeeManagementSystem.client.view.MainView.MainViewModel;

public class ModelFactory {
    private final ClientFactory clientFactory;
    public LoginModelImpl loginModelImpl;
    public MainModelImpl mainModelImpl;


    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    public LoginModel getLoginModel(){
        if(loginModelImpl == null){
            loginModelImpl = (LoginModelImpl) new LoginModelImpl(clientFactory.getLoginClient());
        }
        return loginModelImpl;
    }

    public MainModelImpl getMainModel() {
        if (mainModelImpl == null) {
            mainModelImpl = new MainModelImpl(clientFactory.getMainClient());
        }
        return mainModelImpl;
    }


}
