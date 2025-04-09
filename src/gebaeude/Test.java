package gebaeude;

public class Test {
  public static void main(String... args) {
    Gebaeude ref = null;

    try {
      ref = new Gebaeude("Hauptstr.", 45, 1, 10);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    if (ref != null) {
      System.out.println(ref.getRaum(0, 2));
    }

  }
}
