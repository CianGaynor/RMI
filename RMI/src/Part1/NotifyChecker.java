package Part1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NotifyChecker extends UnicastRemoteObject implements Notify {

    private RMIClient rmiClient;

    private CallbackInterface callbackInterface;


    protected NotifyChecker(CallbackInterface callbackInterface, RMIClient rmiClient) throws RemoteException {
        this.rmiClient = rmiClient;
        this.callbackInterface = callbackInterface;
    }

    @Override
    public void doneIt() throws RemoteException {
        rmiClient.setRisk(callbackInterface.getRisk());
    }
}
