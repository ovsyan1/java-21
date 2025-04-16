package biFunctionMethodReference;

public class Besitzer {
    private final String name;
    private int yearsOfExperience;

    Besitzer(String name) {
        this.name = name;
    }

    Besitzer (Auto auto, Integer i) {
        this.name = auto.getBesitzer().getName();
        this.yearsOfExperience = i;
    }

    public String getName() {
        return this.name;
    }

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public void setYearsOfExperience(int num) {
        this.yearsOfExperience = num;
    }

    public static Besitzer createInstance(Auto auto, Integer i) {
        return new Besitzer(auto, i);
    }


    @Override
    public String toString() {
        return  "Besitzer heißt " + this.name + " und hat " + this.yearsOfExperience + " Jahr/e Fahrerfahrung" ;
    }

}
