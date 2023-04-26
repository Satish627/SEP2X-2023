package EmployeeManagementSystem.client.core;

import EmployeeManagementSystem.client.model.AddEmployee.AddEmployeeImpl;
import EmployeeManagementSystem.client.model.Employee.EmployeeImpl;
import EmployeeManagementSystem.client.model.Login.LoginModel;
import EmployeeManagementSystem.client.model.Login.LoginModelImpl;
import EmployeeManagementSystem.client.model.MainView.MainModelImpl;

public class ModelFactory {
    private final ClientFactory clientFactory;
    public LoginModelImpl loginModelImpl;
    public MainModelImpl mainModelImpl;
    public EmployeeImpl addEmployeeImpl;
    public AddEmployeeImpl addNewEmployeeImpl;


    public ModelFactory(ClientFactory clientFactory)
    {
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
    public EmployeeImpl getAddEmployee() {
        if (addEmployeeImpl == null) {
            addEmployeeImpl = new EmployeeImpl(clientFactory.getEmployeeClient());
        }
        return addEmployeeImpl;
    }
    public AddEmployeeImpl getAddNewEmployee() {
        if (addNewEmployeeImpl == null) {
            addNewEmployeeImpl = new AddEmployeeImpl(clientFactory.geAddEmployeeClient());
        }
        return addNewEmployeeImpl;
    }



}
