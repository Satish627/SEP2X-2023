package EmployeeManagementSystem.shared.model;

public class LeaveRequest
{
    private Shift shift;
    private String reason;

    private String shiftID;

    public LeaveRequest(String shiftID, String reason) {
        this.shiftID= String.valueOf(shift.getShiftID());
        this.reason = reason;
    }

    public String getShiftID(){
        return shiftID;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
