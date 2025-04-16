package biFunctionMethodReference;

import java.util.function.BiFunction;

public class Test {
    public static void main(String... a) {
        BiFunction<Auto, Integer, Besitzer> f1 = new BiFunction<>() {
            @Override
            public Besitzer apply(Auto auto, Integer i) {
                auto.getBesitzer().setYearsOfExperience(i);
                return auto.getBesitzer();
            }
        };
        System.out.println(f1.apply(new Auto("BMW", new Besitzer("Paul")), 1));
        System.out.println("*********\n");

        BiFunction<Auto, Integer, Besitzer> f2 = (auto, integer) -> auto.getBesitzer();
        System.out.println(f2.apply(new Auto("Fiat", new Besitzer("Petro")), 2));
        System.out.println("*********\n");

        BiFunction<Auto, Integer, Besitzer> f3 = (auto, integer) -> Auto.getStaticBesitzer();
        System.out.println(f3.apply(new Auto("Wolga", new Besitzer("Martin")), 3));
        System.out.println("*********\n");

//        BiFunction<Auto, Integer, Besitzer> f4 = Auto::new;

        BiFunction<Auto, Integer, Besitzer> f5 = Auto::getBesitzerWithExperience;
        System.out.println(f5.apply(new Auto("Skoda", new Besitzer("Irina")), 5));
        System.out.println("*********\n");

//        BiFunction<Auto, Integer, Besitzer> f6 = Auto::;


    }
}
