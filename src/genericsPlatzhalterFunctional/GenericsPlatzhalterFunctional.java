package genericsPlatzhalterFunctional;

import java.util.function.Predicate;

public class GenericsPlatzhalterFunctional {
    public static void main(String[] args) {
        Predicate<Number> istPositiv = n -> n.doubleValue() > 0;
        Predicate<Integer> istGerade = x -> x % 2 == 0;
        Predicate<String> istLeer = s -> s.isEmpty();

        Predicate<? super Number> p0;

        p0 = istPositiv; // muss kompilieren
        //p0 = istGerade; // darf nicht kompilieren // cf
        //p0 = istLeer; // darf nicht kompilieren // cf

        p0.test(22);

        Predicate <? super Integer> p1;

        p1 = istPositiv; // muss kompilieren
        p1 = istGerade; // muss kompilieren
        //p1 = istLeer; // darf nicht kompilieren

        p1.test(22); // muss kompilieren

        Predicate<? extends Number> p2;

        p2 = istPositiv; // muss kompilieren
        p2 = istGerade; // muss kompilieren
        //p2 = istLeer; // darf nicht kompilieren

        //p2.test(22); // darf nicht kompilieren
    }
}
