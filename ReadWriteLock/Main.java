package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread thread1 = new Thread(() -> {
            resource1.produce(lock);
        });

        Thread thread2 = new Thread(() -> {
            resource1.produce(lock);
        });

        Thread thread3 = new Thread(() -> {
            resource1.consume(lock);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
