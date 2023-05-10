package EmployeeManagementSystem.shared.model;

public class LeaveRequest
{
    private Shift shift;
    private String reason;

    private int shiftID;

    public LeaveRequest(int shiftID, String reason) {
        this.shiftID=shift.getShiftID();
        this.reason = reason;
    }

    public int getShiftID(){
        return shiftID;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
