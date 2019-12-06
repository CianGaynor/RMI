import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackServerRMI extends UnicastRemoteObject implements CallbackInterface{
    private CallingImplementation ci;

    protected CallbackServerRMI() throws RemoteException {
    }


    @Override
    public void riskCalculator(Notify notify)throws RemoteException{
        ci = new CallingImplementation(notify);
        ci.start();
    }

    @Override
    public float getRisk() {
        return ci.getRisk();
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        CallbackServerRMI callbackServerRMI = new CallbackServerRMI();
        Naming.rebind("Callback", callbackServerRMI);

    }

}
