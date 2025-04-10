package nestedPredicatePersonen;

public class Person {
  private final String vorname;
  private final String nachname;
  private final int geburtsjahr;

  Person(String vorname, String nachname, int geburtsjahr){
    this.vorname = vorname;
    this.nachname = nachname;
    this.geburtsjahr = geburtsjahr;
  }

  public String getNachname() { return this.nachname; }
  public int getGeburstjahr() { return this.geburtsjahr; }

  @Override
  public String toString() {
    return this.vorname + " " + this.nachname + " " + this.geburtsjahr;
  }
}
