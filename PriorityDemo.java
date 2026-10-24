class MyThread extends Thread {
    public void run() {
        System.out.println(
            getName() + " is running. Priority = "
            + getPriority()
        );
    }
}
public class PriorityDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.setName("Low Priority Thread");
        t2.setName("Normal Priority Thread");
        t3.setName("High Priority Thread");
        t1.setPriority(Thread.MIN_PRIORITY);   
        t2.setPriority(Thread.NORM_PRIORITY);   
        t3.setPriority(Thread.MAX_PRIORITY);    
        t1.start();
        t2.start();
        t3.start();
    }
}
