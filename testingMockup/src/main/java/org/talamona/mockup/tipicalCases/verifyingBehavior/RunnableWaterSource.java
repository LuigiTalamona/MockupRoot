package org.talamona.mockup.tipicalCases.verifyingBehavior;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 4:31 PM
 */
public class RunnableWaterSource implements Runnable{
    private WaterSource waterSource;
    private long timeout;

    public RunnableWaterSource(WaterSource waterSource, long timeout){
        this.waterSource = waterSource;
        this.timeout = timeout;
    }

    @Override
    public void run(){
        try {
            System.out.println("Starting WaterSource thread");
            TimeUnit.SECONDS.sleep(this.timeout);
            waterSource.doSelfCheck();
            System.out.println("WaterSource thread terminated");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static Thread createRunnableWaterSource(WaterSource waterSource, long timeout){
        RunnableWaterSource rws = new RunnableWaterSource(waterSource, timeout);
        return new Thread(rws);

    }
}
