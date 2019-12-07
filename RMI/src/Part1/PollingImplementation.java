package Part1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;


public class PollingImplementation extends UnicastRemoteObject implements  RMIinterface {


    public PollingImplementation() throws RemoteException {
        super();
    }

    private  float risk;
    private Random rand = new Random();


    private void setRisk(float risk){
        this.risk = risk;
    }

    @Override
    public void doSomething() throws RemoteException, InterruptedException {
        riskCalculator(metScore());
    }

    @Override
    public boolean isItDone() {
        if (this.risk > 20){
            return true;
        }
        else
            return false;
    }

    @Override
    public void riskCalculator(int cloudCover) throws RemoteException {
        int celsius = rand.nextInt(30);
        int humidity = rand.nextInt(20);


        float risky =  (celsius) * (1 - (humidity/100)) * (1 - (cloudCover/100));

        setRisk(risky);
    }

    @Override
    public int metScore() throws InterruptedException {
        return rand.nextInt(20);
    }

    @Override
    public float getResults() throws InterruptedException, RemoteException {
        return this.risk;
    }


}
