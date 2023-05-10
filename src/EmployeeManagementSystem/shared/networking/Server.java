package EmployeeManagementSystem.shared.networking;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {

    EmployeeServer getEmployeeServer() throws RemoteException;

    LoginServer getLoginServer() throws RemoteException;
    LeaveRequestServer getLeaveRequestServer() throws RemoteException;

    void startServer() throws RemoteException, AlreadyBoundException;

   ShiftServer getShiftServer() throws RemoteException;
}
