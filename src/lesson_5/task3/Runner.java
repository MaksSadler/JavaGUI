package lesson_5.task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable {
    private String name;
    private CountDownLatch readySignal;
    private CountDownLatch cdl1;
    private CountDownLatch cdl2;

    public Runner(String name,CountDownLatch readySignal, CountDownLatch cdl1, CountDownLatch cdl2) {
        this.name = name;
        this.readySignal = readySignal;
        this.cdl1 = cdl1;
        this.cdl2 = cdl2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random(1000).nextInt(5000));
            System.out.println("Участник + " + this.name + " на старте.");
            readySignal.countDown();
            cdl1.await();
            System.out.println("Участник " + this.name + " побежал!");
            Thread.sleep(new Random(1000).nextInt(5000));
            System.out.println("Участник " + this.name + " прибежал!!!");
            cdl2.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
