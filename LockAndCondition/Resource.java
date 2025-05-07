package LockAndCondition;

import java.util.concurrent.locks.ReentrantLock;

public class Resource {

//    ReentrantLock lock = new ReentrantLock();

    // Create monitor lock but dont use synchronized
    public void resource(ReentrantLock lock) {

        try {
            lock.lock();
            System.out.println("Lock acquired by : " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Lock released by : "+ Thread.currentThread().getName());
        }

    }

}
