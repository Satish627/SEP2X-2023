package EmployeeManagementSystem.client.model.ShiftModel;

import EmployeeManagementSystem.shared.Subject;
import EmployeeManagementSystem.shared.model.Shift;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ShiftModel extends Subject
{

    Shift addShift(int employeeID, LocalDate date, String startTime, String endTime) ;

    ArrayList<Shift> viewAllShift();

    ArrayList<Shift> viewAllShiftByUserID(int userID);

    void deleteShift(int eId);

    void checkIn(int shiftID, int userID);
    void checkOut(int shiftID, int userID);

  void updateShift(Shift shift);

    Shift getSelectedShift();
    void setSelectedShift(Shift shift);


}
