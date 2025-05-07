package StampedLocking;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    int a = 10;

    StampedLock lock = new StampedLock();

    // Optimistic lock
    public void produce(){

        long stamp = lock.tryOptimisticRead();
        System.out.println("Lock acquired by thread " + Thread.currentThread().getName());

        try {
            a = 11;
            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("Update done successfully");
            } else{
                System.out.println("Update failed and rollback to default");
                a = 10;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // Actual lock
    public void consume(){
        long stamp = lock.writeLock();

        System.out.println("Lock acquired by thread " + Thread.currentThread().getName());

        try {
            System.out.println("Performing work");
            a = 9;
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Lock released by thread " + Thread.currentThread().getName());
        }



    }


}
