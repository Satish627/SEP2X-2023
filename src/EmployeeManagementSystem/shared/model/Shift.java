package EmployeeManagementSystem.shared.model;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Shift implements Serializable
{
    private int shiftID;
    private int employeeID;
    private String employeeName;
    private LocalDate date;
    private String checkInTime;
    private String checkOutTime;

    private int totalHours;

    public Shift(int shiftID, int employeeID,String employeeName, LocalDate date, String checkInTime, String checkOutTime,int totalHours)
    {
        this.shiftID= shiftID;
        this.employeeID= employeeID;
        this.employeeName = employeeName;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.totalHours=totalHours;
    }

    public Shift(int shiftID, int employeeID, String employeeName, LocalDate date, String checkInTime, String checkOutTime) {
        this.shiftID = shiftID;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public Shift(int shiftID) {
        this.shiftID = shiftID;
    }


    public int  getShiftID() {
        return shiftID;
    }
    public String getEmployeeName()
    {
        return employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }


    public void setShiftID(int  shiftID) {
        this.shiftID = shiftID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDate() {
        this.date = date;

    }

    public int getTotalHours() {
        return totalHours;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiftID=" + shiftID +
                ", employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", date=" + date +
                ", startTime='" + checkInTime + '\'' +
                ", endTime='" + checkOutTime + '\'' +
                '}';
    }
}
