package Part1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notify extends Remote {
    void doneIt() throws RemoteException;
}
