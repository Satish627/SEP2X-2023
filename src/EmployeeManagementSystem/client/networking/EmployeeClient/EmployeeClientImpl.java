package EmployeeManagementSystem.client.networking.EmployeeClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Users;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeClientImpl implements EmployeeClient
{
    private Server server;

    public EmployeeClientImpl() {
        try {
            System.out.println("Hello from  addEmployee client networking!!");
            server= GetServer.getRMIServer();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Users addEmployee(String firstName, String lastName,String password, int userId, String emailId, String address, int phoneNum, String dateOfBirth) {
         try{
             return server.getEmployeeServer().addEmployee(firstName, lastName,password, userId, emailId, address, phoneNum, dateOfBirth);
         } catch (RemoteException | SQLException e) {
            e.printStackTrace();
         }


        return null;
    }

    @Override
    public ArrayList<Users> viewAllEmployees() {
        try{
            return server.getEmployeeServer().viewAllEmployees();
        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployeeInfo(int UserId, String firstName, String lastName, String email, String address, int phoneNum, String DateOfBirth) {
        try {
            server.getEmployeeServer().updateEmployeeInfo(UserId,firstName,lastName,email,address,phoneNum,DateOfBirth);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(int uId) {
        try {
            server.getEmployeeServer().deleteEmployeeById(uId);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
