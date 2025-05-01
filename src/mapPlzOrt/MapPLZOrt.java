package mapPlzOrt;

import java.io.FileNotFoundException;
import java.util.*;

public class MapPLZOrt {
    public static void main(String... args) throws FileNotFoundException {
        Map<String, String> postalCodes = new HashMap<>();
        Map<String, List<String>> cities = new HashMap<>();

        new ReadFile(postalCodes).read("src/mapPlzOrt/PLZ.txt");

        postalCodes.forEach((plz, city) -> {
            if (cities.containsKey(city)) {
                cities.get(city).add(plz);
            } else {
                cities.put(city, new ArrayList<>(Collections.singletonList(plz)));
            }
        });

        new InputScanner(postalCodes, cities).scan();
    }
}
