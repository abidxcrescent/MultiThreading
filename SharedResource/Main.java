package SharedResource;

public class Main {
    public static void main(String[] args) {
        SR sharedResource = new SR();

        System.out.println("Main thread started");

        Thread thread1 = new Thread(() -> {
           System.out.println("Thread 1 calling produce in SharedResource");
            sharedResource.produce();
        });

        Thread thread2 = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("Thread 2 calling produce in SharedResource");
            sharedResource.produce();
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread 1 suspended");

        thread1.suspend();

        System.out.println("Main thread suspended");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread1.resume();

    }
}
