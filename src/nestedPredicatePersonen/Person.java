package nestedPredicatePersonen;

public final record Person(String vorname, String nachname, int geburtsjahr) {
  @Override
  public String toString() {
    return this.vorname + " " + this.nachname + " " + this.geburtsjahr;
  }
}
