package io.serialisierenLebewesen;

class Mensch extends Lebewesen {
  String vorname;
  String nahcname;

  Mensch(String vorname, String nachname) {
    this.vorname = vorname;
    this.nahcname = nachname;
  }

  @Override
  public String toString() {
    return "Besitzer: " + vorname + " " + nahcname;
  }
}
