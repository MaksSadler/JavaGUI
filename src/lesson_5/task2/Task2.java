package lesson_5.task2;

public class Task2 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2(myThread1);

        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread(myThread2);

        t1.start();
        t2.start();

        try {
            t2.join();
            t1.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
