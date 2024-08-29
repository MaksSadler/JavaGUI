package homework_5;

import java.util.concurrent.CountDownLatch;

public class Table extends Thread {
    private final int PHILOSOPHER_COUNT = 5;
    private final Fork[] forks;
    private final Philosopher[] philosophers;
    private final CountDownLatch cdl;

    public Table() {
        forks = new Fork[PHILOSOPHER_COUNT];
        philosophers = new Philosopher[PHILOSOPHER_COUNT];
        cdl = new CountDownLatch(PHILOSOPHER_COUNT);
        init();
    }

    @Override
    public void run() {
        System.out.println("Заседание философов запускается...");
        try {
            thinkingProcess();
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Филосовы наелись.");
    }

    public synchronized boolean tryGetForks(int leftFork, int rightFork) {
        if (forks[leftFork].isUsing() && forks[rightFork].isUsing()) {
            forks[leftFork].setUsing(true);
            forks[rightFork].setUsing(true);
            return true;
        }
        return false;
    }

    public void putForks(int leftFork, int rightFork) {
        forks[leftFork].setUsing(false);
        forks[rightFork].setUsing(false);
    }

    public void init() {
        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            forks[i] = new Fork();
        }
        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            philosophers[i] = new Philosopher("Филосов: " + i, this, i,
                    (i + 1) % PHILOSOPHER_COUNT, cdl);
        }
    }

    private void thinkingProcess() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
