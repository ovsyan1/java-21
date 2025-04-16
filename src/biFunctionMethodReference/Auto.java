package biFunctionMethodReference;

public class Auto {
    private String name;
    private Besitzer besitzer;

    Auto() {}
    Auto(String name, Besitzer besitzer) {
        this.name = name;
        this.besitzer = besitzer;
    }

    public String getName() {
        return this.name;
    }

    public Besitzer getBesitzerWithExperience(Auto a, int i) {
        besitzer.setYearsOfExperience(i);
        return besitzer;
    }


    public Besitzer getBesitzer() {
        return this.besitzer;
    }
}
