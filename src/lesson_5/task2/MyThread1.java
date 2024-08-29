package lesson_5.task2;

public class MyThread1 implements Runnable {
    private volatile Boolean switcher = false;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                switcher = !switcher;
                System.out.println("switcher: " + switcher);
            } catch (InterruptedException e) {
                System.out.println("Программа завершила работу!!!");
                break;
            }
        }
    }

    public boolean isSwitcher() {
        return switcher;
    }
}
