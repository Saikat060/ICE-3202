class MyThread implements Runnable {
    volatile boolean suspended = false, stopped = false;

    public void run() {
        int count = 1;
        while (!stopped) {
            try {
                System.out.println("Thread running... Count: " + count++);
                Thread.sleep(5000);
                synchronized (this) {
                    while (suspended)
                        wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
        System.out.println("Thread stopped successfully.");
    }

    synchronized void mySuspend() {
        suspended = true;
        System.out.println("\n[Action] Thread Suspended...\n");
    }

    synchronized void myResume() {
        suspended = false;
        notifyAll();
        System.out.println("\n[Action] Thread Resumed...\n");
    }

    synchronized void myStop() {
        stopped = true;
        suspended = false;
        notifyAll();
        System.out.println("\n[Action] Thread Stopping...\n");
    }
}

public class ThreadControl {
    public static void main(String[] args) throws InterruptedException {
        MyThread r = new MyThread();
        Thread t = new Thread(r);
        System.out.println("--- Starting Thread Execution ---");
        t.start();
        Thread.sleep(2000);
        r.mySuspend();
        Thread.sleep(2000);
        r.myResume();
        Thread.sleep(2000);
        r.myStop();
    }
}