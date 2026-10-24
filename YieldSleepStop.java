class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    getName() + " - Count: " + i);
            if (i == 2) {
                Thread.yield();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
                return;
            }
        }
        System.out.println(getName() + " completed.");
    }
}

public class YieldSleepStop {
    public static void main(String[] args)
            throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("Thread-A");
        t2.setName("Thread-B");
        t1.start();
        t2.start();
        Thread.sleep(1200);
        t1.interrupt();
    }
}