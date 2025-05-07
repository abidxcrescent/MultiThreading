package LockAndCondition;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 is running");
            resource1.resource(lock);
        });

        Resource resource2 = new Resource();

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 is running");
            resource2.resource(lock);
        });

        thread1.start();
        thread2.start();

    }
}
