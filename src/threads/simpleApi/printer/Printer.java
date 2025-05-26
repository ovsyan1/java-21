package threads.simpleApi.printer;

public class Printer extends Thread {
    private final char zeichen;
    private final int anzahl;
    private int linieAnzahl;


    Printer(char zeichen, int anzahl, int linieAnzahl) {
        this.zeichen = zeichen;
        this.anzahl = anzahl;
        this.linieAnzahl = linieAnzahl;
    }

    @Override
    public void run(){
        while (linieAnzahl > 0) {
            synchronized (System.out) {
            for (int i = 1; i < anzahl; i++) {
                System.out.print(zeichen);
                if (anzahl - 1 == i) {
                    System.out.println(zeichen);
                }
            }
          }
//          try {
//              Thread.sleep(100);
//          } catch (InterruptedException e) {}

            linieAnzahl--;
        }
    }


    public static void main(String... args) {
        Printer p1 = new Printer('a', 10, 20);
        p1.start();

        Printer p2 = new Printer('*', 15, 40);
        p2.start();
    }
}
