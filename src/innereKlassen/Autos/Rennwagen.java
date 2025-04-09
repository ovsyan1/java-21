package innereKlassen.Autos;

public class Rennwagen {
  private final String title;
  private Fahrer fahrer;

  Rennwagen(String title) {
    this.title = title;
  }

  public void setFahrer(Fahrer fahrer) {
    this.fahrer = fahrer;
  }

  public Motor getMotor() {
    return this.new Motor("Type1");
  }

  class Motor {
    private final String type;

    Motor(String type) {
      this.type = type;
    }

    @Override
    public String toString() {
      return "Motor " + this.type + " aus dem Rennwagen " + Rennwagen.this.title;
    }
  }

  static class Fahrer {
    private final String firstName;
    final private String lastName;

    Fahrer(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }
  }

  @Override
  public String toString() {
    return "Rennwagen " + this.title + ". Fahrer: " + this.fahrer.firstName + " " + this.fahrer.lastName;
  }
}
