class CustomThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " executing step: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class CreateThread {
    public static void main(String[] args) throws InterruptedException {
        CustomThread thread1 = new CustomThread();
        CustomThread thread2 = new CustomThread();
        thread1.setName("Thread-A");
        thread2.setName("Thread-B");
        thread1.start();
        // thread1.join();
        thread2.start();
        // thread2.join();
    }
}
