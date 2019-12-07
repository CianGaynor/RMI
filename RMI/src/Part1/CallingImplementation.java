package Part1;

import java.rmi.RemoteException;
import java.util.Random;

public class CallingImplementation extends Thread{

    private Notify notify;
    private Random random = new Random();
    private float risk;

    public CallingImplementation(Notify notify){
        this.notify = notify;
    }

    @Override
    public void run(){
        float humidity = random.nextInt(20);
        float celsius = random.nextInt(30);
        float cloud = random.nextInt(20);

        this.risk =  (celsius) * (1 - (humidity/100)) * (1 - (cloud/100));

        try {
            notify.doneIt();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public float getRisk(){
        return this.risk;
    }

}
