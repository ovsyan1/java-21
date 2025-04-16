package biFunctionMethodReference;

public class Besitzer {
    private final String name;
    private int yearsOfExperience;

    Besitzer(String name) {
        this.name = name;
    }

//    Besitzer(String name, int yearsOfExperience) {
//        this.name = name;
//        this.yearsOfExperience = yearsOfExperience;
//    }

    public String getName() {
        return this.name;
    }

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public void setYearsOfExperience(int num) {
        this.yearsOfExperience = num;
    }


    @Override
    public String toString() {
        return  "Besitzer heißt " + this.name + " und hat " + this.yearsOfExperience + " Jahr/e Fahrerfahrung" ;
    }

}
