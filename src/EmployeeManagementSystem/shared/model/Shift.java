package EmployeeManagementSystem.shared.model;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Shift implements Serializable
{
    private int shiftID;

    private String employeeName;
    private int employeeID;
    private LocalDate date;
    private String checkInTime;
    private String checkOutTime;

    public Shift(int shiftID, int employeeID, LocalDate date, String checkInTime, String checkOutTime) {

        this.shiftID= shiftID;
        this.employeeID= employeeID;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
    public Shift( int employeeID, LocalDate date, String checkInTime, String checkOutTime, String employeeName) {

        this.employeeID= employeeID;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.employeeName = employeeName;
    }

    public Shift(int shiftID, int employeeID, LocalDate date, String checkInTime, String checkOutTime, String employeeName) {

        this.shiftID= shiftID;
        this.employeeID= employeeID;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.employeeName= employeeName;
    }


    public Shift(int shiftID) {
        this.shiftID = shiftID;
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

    public String getCheckInTime() {
        return checkInTime;
    }

    public int getTotalHours() {
        Duration between = Duration.between(LocalTime.parse(checkInTime), LocalTime.parse(checkOutTime));
        return between.toHoursPart();
    }

    public String getStatus(){
        return LocalDate.now().isBefore(date) ? "UPCOMING" : "PAST";
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
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

    @Override
    public String toString() {
        return "Shift{" +
                "shiftID=" + shiftID +
                ", employeeID=" + employeeID +
                ", date=" + date +
                ", startTime='" + checkInTime + '\'' +
                ", endTime='" + checkOutTime + '\'' +
                '}';
    }

    public Shift copy(){
        return new Shift(shiftID, employeeID,date, checkInTime, checkOutTime, employeeName);
    }
}
