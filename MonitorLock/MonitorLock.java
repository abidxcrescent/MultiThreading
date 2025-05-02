package MonitorLock;

public class MonitorLock {

   public synchronized void method1(){
       System.out.println("MonitorLock method1");
       try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       System.out.println("MonitorLock method1 after Synchronization");
   }

   public void method2(){
       System.out.println("MonitorLock method before synchronization");
       synchronized (this) {
           System.out.println("MonitorLock method2 after synchronization");
       }
   }

   public void method3(){
       System.out.println("MonitorLock method no synchronization");
   }

}
