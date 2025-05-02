package MonitorLock;

public class MonitorLockMain {
    public static void main(String[] args) {
        System.out.println("MonitorLock main");
        MonitorLock ml = new MonitorLock();
        Thread thread1 = new Thread(ml::method1);
        Thread threat2 = new Thread(ml::method2);
        Thread threat3 = new Thread(ml::method3);
        thread1.start();
        threat2.start();
        threat3.start();
    }
}
