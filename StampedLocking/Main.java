package StampedLocking;

public class Main {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();

        Thread thread1 = new Thread(() -> resource1.produce());
        Thread thread2 = new Thread(() -> resource1.consume());

        thread1.start();
        //thread2.start();


    }
}
