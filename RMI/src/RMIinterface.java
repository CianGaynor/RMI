import java.rmi.RemoteException;

public interface RMIinterface {
    void doSomething() throws RemoteException;
    boolean isItDone();
    void riskCalculator(int i) throws RemoteException;
    int metScore();
}
