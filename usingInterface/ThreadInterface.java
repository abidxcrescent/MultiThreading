package usingInterface;

public class ThreadInterface implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running " + Thread.currentThread().getName());
    }
}
