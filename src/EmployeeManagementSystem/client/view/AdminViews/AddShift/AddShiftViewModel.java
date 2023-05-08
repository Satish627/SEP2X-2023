package EmployeeManagementSystem.client.view.AdminViews.AddShift;

import EmployeeManagementSystem.client.model.ShiftModel.ShiftModel;
import EmployeeManagementSystem.shared.model.Shift;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddShiftViewModel {
    private ShiftModel addShiftModel;
    private StringProperty shiftID, employeeID, date, startTime, endTime;

    public AddShiftViewModel(ShiftModel addNewShiftModel) {
        this.addShiftModel = addNewShiftModel;
        initialiseAllProperty();
    }

    private void initialiseAllProperty() {
        shiftID = new SimpleStringProperty();
        employeeID = new SimpleStringProperty();
        date = new SimpleStringProperty();
        startTime = new SimpleStringProperty();
        endTime = new SimpleStringProperty();
    }

    public StringProperty getShiftID() {
        return shiftID;
    }

    public StringProperty getEmployeeID() {
        return employeeID;
    }

    public StringProperty getDate() {
        return date;
    }

    public StringProperty getStartTime() {
        return startTime;
    }

    public StringProperty getEndTime() {
        return endTime;
    }

    public Shift addShift() throws SQLException, RemoteException {
        if (shiftID.get() == null || shiftID.get().isEmpty() || employeeID.get() == null || employeeID.get().isEmpty()|| date != null || date.get().isEmpty()|| startTime.get() == null || startTime.get().isEmpty() || endTime.get() == null || endTime.get().isEmpty())
        {
            System.out.println("Please fill in all the information");
            return null; // Return null indicating that the shift was not added
        }

        try {
            int parsedShiftID = Integer.parseInt(shiftID.get());
            int parsedEmployeeID = Integer.parseInt(employeeID.get());
            LocalDate parsedDate = LocalDate.parse(date.get());
            int parsedStartTime = Integer.parseInt(startTime.get());
            int parsedEndTime = Integer.parseInt(endTime.get());

            addShiftModel.addShift(parsedShiftID, parsedEmployeeID, parsedDate, parsedStartTime, parsedEndTime);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please provide valid integer values for shift ID, employee ID, date, start time, and end time.");
            return null; // Return null indicating that the shift was not added
        }

        // Add any additional success message or post-processing logic here
        return null; // Replace with the actual Shift object if needed
    }

}
