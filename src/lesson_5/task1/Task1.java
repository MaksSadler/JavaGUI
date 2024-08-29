package lesson_5.task1;

public class Task1 {
    static Object objectA = new Object();
    static Object objectB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                workingThread1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                workingThread2();
            }
        });
        thread1.start();
        thread2.start();

    }

    public static void workingThread1() {
        synchronized (objectA) {
            try {
                System.out.println("Поток один захватил объект А.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectB) {
                System.out.println("Поток один захватил объект B.");
            }
        }
    }

    public static void workingThread2() {
        synchronized (objectB) {
            System.out.println("Поток два захватил объект B.");
            synchronized (objectA) {
                System.out.println("Поток два захватил объект А.");
            }
        }
    }

}
