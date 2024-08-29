package lesson_5.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Task3 {
    private final static int COUNT_RUNNERS = 3;

    public static void main(String[] args) {
        CountDownLatch readySignal = new CountDownLatch(COUNT_RUNNERS);
        CountDownLatch cdl1 = new CountDownLatch(1);
        CountDownLatch cdl2 = new CountDownLatch(COUNT_RUNNERS);

        List<Runner> runners = new ArrayList<>(Arrays.asList(
                new Runner("Вася",readySignal,cdl1,cdl2),
                new Runner("Петя",readySignal,cdl1,cdl2),
                new Runner("Маша",readySignal,cdl1,cdl2)
        ));
        new Thread(new Race(readySignal,cdl1,cdl2)).start();
        for(Runner runner : runners) {
            new Thread(runner).start();
        }
    }
}
