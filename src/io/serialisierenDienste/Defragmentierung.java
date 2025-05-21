package io.serialisierenDienste;

class Defragmentierung extends Dienst {
  int zeitabstand;
  String laufwerk;

  Defragmentierung(int zeitabstand, String laufwerk) {
    this.zeitabstand = zeitabstand;
    this.laufwerk = laufwerk;
  }


  @Override
  public String toString() {
    return "Zeitabstand(" + this.zeitabstand + "), LW(" + this.laufwerk + ")";
  }
}
