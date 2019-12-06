import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class RMIServerTemp  {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        //Polling
        RMIinterface temp = new PollingImplementation();
        Naming.rebind("Risk_Calc", temp);
    }
}
