package EmployeeManagementSystem.client.networking.ShiftClient;

import EmployeeManagementSystem.shared.Subject;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ShiftClient extends Subject {
    Shift addShift(int shiftID, int employeeID, String employeeName, LocalDate date, String startTime, String endTime) throws RemoteException, SQLException;

    ArrayList<Shift> viewAllShift();

    void deleteShift(int eId);
}
