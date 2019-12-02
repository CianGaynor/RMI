import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    private static RMIinterface temp;

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, InterruptedException {
        while(!temp.isItDone()) {
            System.out.println("Checking...");
            temp.doSomething();
            temp.isItDone();
            Thread.sleep(10000);
        }
    }
}
