package threads.simpleApi.philosophenProblem;

class Philosoph implements Runnable {
  private final String name;
  private Object linkeGable, rechteGable;


  Philosoph(String name) {
    this.name = name;
  }

  void setLinkeGabel(Object linkeGable) {
    this.linkeGable = linkeGable;
  }

  void setRechteGable(Object rechteGable) {
    this.rechteGable = rechteGable;
  }

  @Override
  public void run() {
    while(true) {
      System.out.println(this.name + " denkt nach...");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      System.out.println(this.name + " hat Hunger");

      synchronized (linkeGable) {
        System.out.println(this.name + " nimmt die linke Gabel");

        synchronized (rechteGable) {
          System.out.println(this.name + " nimmt die rechte Gabel");

          System.out.println(this.name + " isst...");
          try {
            Thread.sleep(300);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println(this.name + " legt die rechte Gabel ab");
        }
      }


      System.out.println(this.name + " legt die linke Gabel ab");
      System.out.println();
    }
  }

  @Override
  public String toString() {
    return this.name;
  }
}
