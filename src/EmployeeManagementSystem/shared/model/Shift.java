package EmployeeManagementSystem.shared.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Shift implements Serializable
{
    private int shiftID;
    private int employeeID;
    private String employeeName;
    private LocalDate date;
    private String startTime;
    private String endTime;

    public Shift(int shiftID, int employeeID,String employeeName, LocalDate date, String startTime, String endTime)
    {
        this.shiftID= shiftID;
        this.employeeID= employeeID;
        this.employeeName = employeeName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int  getShiftID() {
        return shiftID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setShiftID(int  shiftID) {
        this.shiftID = shiftID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setLocalDate() {
        this.date = date;
    }

    public void setStartTime() {
        this.startTime = startTime;
    }

    public void setEndTime() {
        this.endTime = endTime;
    }
}
