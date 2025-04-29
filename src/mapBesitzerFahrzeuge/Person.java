package mapBesitzerFahrzeuge;

class Person {
    private String vorname;
    private String nachname;

    Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return "Name: " + this.vorname + " " + this.nachname;
    }
}
