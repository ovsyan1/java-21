package threads.simpleApi.deadLock;

public class DeadLock {
  public static final Object monitor1 = new Object();
  public static final Object monitor2 = new Object();

  public static void main(String... args) {
    new Thread1().start();
    new Thread2().start();
  }
}

class Thread1 extends Thread {
  @Override
  public void run() {
    System.out.println("Thread1 - start");
    synchronized (DeadLock.monitor1) {
      System.out.println("Thread1 - start sync block");
      synchronized (DeadLock.monitor2) {
        System.out.println("Thread1 - nested sync block");
      }
    }
  }
}

class Thread2 extends Thread {
  @Override
  public void run() {
    System.out.println("Thread2 - start");
    synchronized (DeadLock.monitor2) {
      System.out.println("Thread2 - in sync block");
      synchronized (DeadLock.monitor1) {
        System.out.println("Thread2 - nested sync block");
      }
    }
  }
}
