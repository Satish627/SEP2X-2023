package EmployeeManagementSystem.shared;

import java.beans.PropertyChangeListener;

public interface Subject {
    void addListener( PropertyChangeListener listener);
    void removeListener(String eventName, PropertyChangeListener listener);
}
