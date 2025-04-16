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

        BiFunction<Auto, Integer, Besitzer> f3 = Besitzer::createInstance;
        System.out.println(f3.apply(new Auto("Wolga", new Besitzer("Martin")), 3));
        System.out.println("*********\n");

        BiFunction<Auto, Integer, Besitzer> f4 = Besitzer::new;
        System.out.println(f4.apply(new Auto("Wolgaqqqq", new Besitzer("Elly")), 13));
        System.out.println("*********\n");

        BiFunction<Auto, Integer, Besitzer> f5 = new Auto("Toyota", new Besitzer("Volvic"))::getBesitzerWithExperience;
        System.out.println(f5.apply(new Auto(), 5));
        System.out.println("*********\n");

//        BiFunction<Auto, Integer, Besitzer> f6 = Auto::;


    }
}
