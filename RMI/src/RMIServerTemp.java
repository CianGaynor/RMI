import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class RMIServerTemp extends UnicastRemoteObject implements  RMIinterface {

    private RMIServerTemp() throws RemoteException {
        super();
    }
    private  float risk;
    private Random rand = new Random();

    @Override
    public int metScore() {
        return rand.nextInt(20);
    }

    private void setRisk(float risk){
        this.risk = risk;
    }

    @Override
    public void riskCalculator(int cloudCover) throws RemoteException {
        int celsius = rand.nextInt(30);
        int humidity = rand.nextInt(20) / 100;

        float risky =  (celsius) * (1 - humidity) * (100 - cloudCover);

        setRisk(risky);
    }

    @Override
    public void doSomething() throws RemoteException {
        riskCalculator(metScore());
    }

    @Override
    public boolean isItDone() {
        if (this.risk > 20){
            System.out.println("Checking...risk detected(" + this.risk + ")");
            return true;
        }
        else
            return false;
    }


    public static void main(String[] args) throws RemoteException, MalformedURLException {
        RMIServerTemp temp = new RMIServerTemp();
        Naming.rebind("Risk_Calc", temp);
    }
}
