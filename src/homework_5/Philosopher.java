package homework_5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private final String name;
    private final int leftFork;
    private final int rightFork;
    private int countEat;
    private final Random random;
    private final CountDownLatch cdl;
    private final Table table;

    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl) {
        this.table = table;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        countEat = 0;
        random = new Random();
    }

    @Override
    public void run() {
        while (countEat < 3) {
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " Объелся");
        cdl.countDown();
    }

    private void eating() throws InterruptedException {
        if (table.tryGetForks(leftFork, rightFork)) {
            System.out.println(name + " Ест макароны, вилками " + rightFork + " и " + leftFork);
            sleep(random.nextLong(3000, 6000));
            table.putForks(leftFork, rightFork);
            System.out.println(name + " Поел, можно и помыслить...\n " +
                    "не забыв при этом вернуть вилки " + leftFork + rightFork);
            countEat++;
        }
    }

    private void thinking() throws InterruptedException {
        sleep(random.nextLong(300, 3000));
    }
}
