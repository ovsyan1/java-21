package genericsGarage;

import java.util.*;

interface Fahrzeug {
}

class PKW implements Fahrzeug {
}

class LKW implements Fahrzeug {
}

class Garage<T extends Fahrzeug> {
    private final List<T> fahrzeuge = new ArrayList<>(1);

    void reinfahren(T fahrzeug) {
        if(!this.fahrzeuge.isEmpty()) {
            throw new RuntimeException("Es gibt kein Platz fur den Fahrzeug mehr :(");
        }
        this.fahrzeuge.add(fahrzeug);
    }

    @Override
    public String toString() {
        return !this.fahrzeuge.isEmpty() ? "Die Garage ist voll." : "Es gibt noch Platz in der Garage!";
    }
}

public class GenericsGarage {
    public static void main(String... a) {
        Garage<PKW> garageFuerPKW = new Garage<>();
        Garage<LKW> garageFuerLKW = new Garage<>();

        garageFuerPKW.reinfahren(new PKW());
//        garageFuerPKW.reinfahren(new LKW()); // cf

        garageFuerLKW.reinfahren(new LKW());

        System.out.println(garageFuerPKW);

//        garageFuerPKW.reinfahren(new PKW()); // darf man nicht mehr den Fahrzeug parken.

        Garage<LKW> leereGarage = new Garage<>();
        System.out.println(leereGarage);
    }

}
