package lesson_5.task2;

public class MyThread2 implements Runnable {
    private int counter = 100;
    private MyThread1 thread1;

    public MyThread2(MyThread1 thread1) {
        this.thread1 = thread1;
    }
    @Override
    public void run() {
        while (counter >= 0) {
            if (thread1.isSwitcher()) {
                try {
                    Thread.sleep(100);
                    System.out.println(counter--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
