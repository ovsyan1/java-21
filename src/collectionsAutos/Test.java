package collectionsAutos;

import java.util.List;
import java.util.LinkedList;
import java.util.Collection;

public class Test {
    public static void main(String... args) {
        VW vw = new VW("Golf", 1990);
        BMW bmw = new BMW("Z4", 2000);

        System.out.println(vw);
        System.out.println(bmw);

        System.out.println("**************");

        VW vw1 = new VW("Golf", 1990);
        VW vw2 = new VW("Polo", 2010);
        VW vw3 = new VW("Grand California", 2025);

        List<VW> vwList = new LinkedList<>();

        vwList.add(vw1);
        vwList.add(vw2);
        vwList.add(vw3);

        vwList.sort((a, b) -> a.modell.compareTo(b.modell) == 0 ? a.baujahr - b.baujahr : a.modell.compareTo(b.modell));

        printCollection(vwList);
    }

    static <T extends VW> void printCollection(Collection<T> collection) {
        collection.forEach(System.out::println);
    }
}
