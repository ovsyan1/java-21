package mapPlzOrt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MapPLZOrt {
    public static void main(String... args) throws FileNotFoundException {
        Map<Integer, String> mapOfPostalCodes = new HashMap<>();
        Map<String, List<String>> mapOfCities = new HashMap<>();

        try (Scanner sc = new Scanner(new File("src/mapPlzOrt/PLZ.txt"));) {
            String currentCity = null;
            List<String> listOfPostalCodes = new ArrayList<>();

            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split("\t");

                if (parts.length == 2) {
                    String postalCode = parts[0].replace("\"", "");
                    String city = parts[1].replace("\"", "");

                    mapOfPostalCodes.put(Integer.valueOf(postalCode), city);

                    if(currentCity == null || currentCity.equals(city) || mapOfCities.containsKey(city)) {
                        currentCity = city;

                        listOfPostalCodes.add(postalCode);
                        mapOfCities.put(city, listOfPostalCodes);
                    } else {
                        List<String> localList = new ArrayList<>(listOfPostalCodes);
                        mapOfCities.put(currentCity, localList);
                        localList.add(postalCode);
                        mapOfCities.put(city, localList);

                        currentCity = city;
                        listOfPostalCodes.clear();
                    }
                } else {
                    System.out.println("Unexpected format.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        mapOfCities.forEach(((a, b) -> System.out.println(a + " " + b)));

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Please provide postalcode");
                if (scanner.hasNext()) {
                    String city = mapOfPostalCodes.get(Integer.valueOf(scanner.next()));
                    if (city != null) {
                        System.out.println(city);
                        System.out.println("Thanks for using over app");
                        break;
                    } else {
                        //throw new IllegalArgumentException("Please provide right postalcode");
                        System.err.println("This postalcode isn't from Germany!");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
