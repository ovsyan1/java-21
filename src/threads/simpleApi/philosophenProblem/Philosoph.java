package threads.simpleApi.philosophenProblem;

import java.util.concurrent.locks.Lock;

class Philosoph extends Thread {
  private final String name;
  private Lock linkeGable;
  private Lock rechteGabel;


  Philosoph(String name, Lock lock) {
    this.name = name;
    this.start();
  }

  void setLinkeGable(Lock linkeGable) {
    this.linkeGable = linkeGable;
  }

  void setRechteGabel(Lock rechteGabel) {
    this.rechteGabel = rechteGabel;
  }


  @Override
  public void run() {

    while (true) {
      System.out.println(this.name + " denkt nach...");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      System.out.println(this.name + " hat Hunger");

      if (linkeGable.tryLock()) {
        try {
          System.out.println(this.name + " nimmt die linke Gabel");
          if (rechteGabel.tryLock()) {
            try {
              System.out.println(this.name + " nimmt die rechte Gabel");
              System.out.println(this.name + " isst...");
              try {
                Thread.sleep(300);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println(this.name + " legt die rechte Gabel ab");

            } finally {
              rechteGabel.unlock();
            }

        }
          System.out.println(this.name + " legt die linke Gabel ab");
          System.out.println();
        } finally {
          linkeGable.unlock();
        }
      }
    }
  }

  @Override
  public String toString() {
    return this.name;
  }
}
