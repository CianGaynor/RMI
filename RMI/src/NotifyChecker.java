import java.rmi.RemoteException;

public class NotifyChecker implements Notify {

    @Override
    public void doneIt(double risk) throws RemoteException {
        System.out.println("Checking..risk(" + risk +")");
    }
}
