package EmployeeManagementSystem.client.networking.ShiftClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.networking.Server;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShiftClientImpl implements ShiftClient
{
    private Server server;

    public ShiftClientImpl() {
        try {
            System.out.println("Hello from  addShift client networking!!");
            server= GetServer.getRMIServer();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime) throws RemoteException, SQLException {
        return server.getShiftServer().addShift(shiftID, employeeID, employeeName, date, startTime, endTime);
    }

    @Override
    public ArrayList<Shift> viewAllShift()
    {
        try{
            return server.getShiftServer().viewAllShift();
        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }



}
