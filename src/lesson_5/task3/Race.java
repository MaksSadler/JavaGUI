package lesson_5.task3;

import java.util.concurrent.CountDownLatch;

public class Race implements Runnable {
    private CountDownLatch readySignal;
    private CountDownLatch cdl1;
    private CountDownLatch cdl2;

    public Race(CountDownLatch readySignal, CountDownLatch cdl1, CountDownLatch cdl2) {
        this.readySignal = readySignal;
        this.cdl1 = cdl1;
        this.cdl2 = cdl2;
    }

    @Override
    public void run() {
        try {
            readySignal.await();
            System.out.println("На старт!");
            Thread.sleep(100);
            System.out.println("Внимание!");
            Thread.sleep(100);
            System.out.println("Марш!");
            cdl1.countDown();
            cdl2.await();
            System.out.println("Забег окончен.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
