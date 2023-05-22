package EmployeeManagementSystem.shared.model;

import java.io.Serializable;

public class LeaveRequest implements Serializable
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
    public void setShiftID(int shiftID)
    {
        this.shiftID = shiftID;
    }
}
