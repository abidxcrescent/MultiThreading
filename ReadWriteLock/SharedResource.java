package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    // Read Lock (Shared Lock)
    public void produce(ReadWriteLock lock) {

        try {
            lock.readLock().lock();
            System.out.println("Lock acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
//            lock.readLock().unlock();
//            System.out.println("Lock released by thread " + Thread.currentThread().getName());
        }

    }

    // Write lock (Xclusive lock)
    public void consume(ReadWriteLock lock) {

        try {
            lock.writeLock().lock();
            System.out.println("Lock acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
            System.out.println("Lock released by thread " + Thread.currentThread().getName());
        }

    }

}
