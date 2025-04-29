package mapBesitzerFahrzeuge;

import java.util.*;

public class Test {
    public static void main(String... args) {
        Person person1 = new Person("Jeanne", "Boyarsky");
        Person person2 = new Person("Scott", "Selikoff");
        Person person3 = new Person("David", "Götte");

        Fahrzeug fahrzeug1 = new Fahrzeug("Z4", "BMW");
        Fahrzeug fahrzeug2 = new Fahrzeug("Niva", "Lada");
        Fahrzeug fahrzeug3 = new Fahrzeug("Polo", "VW");
        Fahrzeug fahrzeug4 = new Fahrzeug("i30", "Hyundai");

        Map<Fahrzeug, Person> map = new HashMap<>();

        map.put(fahrzeug1, person1);
        map.put(fahrzeug2, person2);
        map.put(fahrzeug3, person3);
        map.put(fahrzeug4, person1);

        System.out.println(map.get(fahrzeug1));

        Map<Person, List<Fahrzeug>> map1 = new HashMap<>();

        map1.put(person1, new ArrayList<>(List.of(fahrzeug1, fahrzeug4)));
        map1.put(person2, new ArrayList<>(List.of(fahrzeug2)));
        map1.put(person3, new ArrayList<>(List.of(fahrzeug3)));

        System.out.println(map1.get(person1));

        System.out.println("****************");
        showElements(map);

        System.out.println("****************");
        showElements(map1);

    }

    static <K, V> void showElements(Map<K, V> map) {
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
