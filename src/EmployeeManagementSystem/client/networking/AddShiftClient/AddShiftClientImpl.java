package EmployeeManagementSystem.client.networking.AddShiftClient;

import EmployeeManagementSystem.client.networking.GetServer;
import EmployeeManagementSystem.shared.model.Shift;
import EmployeeManagementSystem.shared.networking.Server;
import EmployeeManagementSystem.shared.networking.ShiftServer;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddShiftClientImpl implements AddShiftClient
{
    private Server server;

    public AddShiftClientImpl() {
        try {
            System.out.println("Hello from  addEmployee client networking!!");
            server= GetServer.getRMIServer();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime) {
        try {
            return server.getShiftServer().addShift(shiftID, employeeID, employeeName, date, startTime, endTime);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
