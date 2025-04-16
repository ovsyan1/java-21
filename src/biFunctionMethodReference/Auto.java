package biFunctionMethodReference;

//public record Auto(String name, Besitzer besitzer) {}

public class Auto {
    private final String name;
    private Besitzer besitzer;
    private int yearOfCar;

    Auto(String name, Besitzer besitzer) {
        this.name = name;
        this.besitzer = besitzer;
    }

    Auto(Auto auto, Integer integer) {
        this.name = auto.getName();
        this.yearOfCar = integer;
    }

    public String getName() {
        return this.name;
    }

    public Besitzer getBesitzerWithExperience(int i) {
        besitzer.setYearsOfExperience(i);
        return besitzer;
    }


    public Besitzer getBesitzer() {
        return this.besitzer;
    }

    public static Besitzer getStaticBesitzer() {
        return new Besitzer("Static Stefan");
    }

    public int getBesitzerExperience() {
        return besitzer.getYearsOfExperience();
    }
}
