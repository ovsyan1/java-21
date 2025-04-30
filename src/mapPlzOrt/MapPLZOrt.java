package mapPlzOrt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MapPLZOrt {
    public static void main(String... args) throws FileNotFoundException {
        Map<Integer, String> mapOfPostalCodes = new HashMap<>();

        try (Scanner sc = new Scanner(new File("src/mapPlzOrt/PLZ.txt"));) {
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split("\t");

                if (parts.length == 2) {
                    String postalCode = parts[0].replace("\"", "");
                    String city = parts[1].replace("\"", "");

                    mapOfPostalCodes.put(Integer.valueOf(postalCode), city);
                } else {
                    System.out.println("Unexpected format.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

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
