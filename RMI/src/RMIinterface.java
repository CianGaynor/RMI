import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIinterface extends Remote {
    void doSomething() throws RemoteException, InterruptedException;
    boolean isItDone() throws RemoteException, InterruptedException;
    void riskCalculator(int i) throws RemoteException, InterruptedException;
    int metScore() throws InterruptedException, RemoteException;
    float getResults()throws InterruptedException, RemoteException;


}
