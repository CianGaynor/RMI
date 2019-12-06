import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallbackInterface extends Remote {
     void riskCalculator(Notify notify)throws  RemoteException;
     float getRisk()throws RemoteException;
}
