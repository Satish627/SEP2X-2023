package EmployeeManagementSystem.shared.model;

public class LeaveRequest
{
    private int shiftID;
    private String reason;

    public LeaveRequest(int shiftID, String reason) {
        this.shiftID=shiftID;
        this.reason = reason;
    }

    public int getShiftID() {
        return shiftID;
    }

    public String getReason() {
        return reason;
    }


    public void setReason(String reason) {
        this.reason = reason;
    }
}
