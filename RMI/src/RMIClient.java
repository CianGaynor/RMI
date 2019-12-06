import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    private float risk;

    public void setRisk(float r){
        this.risk = r;
    }


    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, InterruptedException  {
        //Callback
//        RMIClient rmiClient = new RMIClient();
//        CallbackInterface cbi = (CallbackInterface) Naming.lookup("rmi://localhost/Callback");
//
//
//        NotifyChecker notifyChecker = new NotifyChecker(cbi, rmiClient);
//
//
//        while(rmiClient.risk < 20){
//            cbi.riskCalculator(notifyChecker);
//            notifyChecker.doneIt();
//            Thread.sleep(10000);
//            System.out.println("Checking...");
//        }
//        System.out.println("Checking..risk detected(" + rmiClient.risk + ")");



//        Polling
        RMIinterface rmi = (RMIinterface) Naming.lookup("rmi://localhost/Risk_Calc");

        while(!rmi.isItDone()) {
            System.out.println("Checking...");
            rmi.doSomething();
            rmi.isItDone();
            Thread.sleep(10000);
        }
        System.out.println("Checking...risk detected(" + rmi.getResults() + ")");
    }


}
