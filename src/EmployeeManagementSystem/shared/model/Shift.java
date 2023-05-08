package EmployeeManagementSystem.shared.model;

import java.time.LocalDate;

public class Shift
{
    private int shiftID;
    private int employeeID;
    private LocalDate date;
    private int startTime;
    private int endTime;


    public Shift(int shiftID, int employeeID, LocalDate date, int startTime, int endTime)
    {
        this.shiftID= shiftID;
        this.employeeID= employeeID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getShiftID() {
        return shiftID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setShiftID(int shiftID) {
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
