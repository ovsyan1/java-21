package innereKlassen.Autos;

public class Test {
  public static void main(String[] args) {
    Rennwagen rw = new Rennwagen("Mercedes");

    Rennwagen.Fahrer f = new Rennwagen.Fahrer("M.", "Schuhmacher");
    rw.setFahrer(f);

    Rennwagen.Motor m = rw.getMotor();

    System.out.println(rw);
    System.out.println(m);
  }
}
