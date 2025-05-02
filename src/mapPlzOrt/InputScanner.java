package mapPlzOrt;

import java.util.Map;
import java.util.List;
import java.util.Scanner;

class InputScanner extends MyScanner {
    private final Map<String, List<String>> cities;

    InputScanner(Map<String, String> postalCodes, Map<String, List<String>> cities) {
        super(postalCodes);
        this.cities = cities;
    }

    void scan() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Please provide Postal code or City");
                if (scanner.hasNext()) {
                    String next = scanner.next();
                    if (!next.chars().allMatch(Character::isDigit)) {
                        List<String> postalCodes = cities.get(next.substring(0, 1).toUpperCase() + next.substring(1));
                        if (postalCodes == null) {
                            System.err.println(next + " There is no such city in Germany");
                        } else {
                            System.out.println("Available postal codes for this city: " + postalCodes);
                            System.out.println("Thanks for using over app");
                            break;
                        }
                    } else {
                        String city = postalCodes.get(next);

                        if (city != null) {
                            System.out.println(city);
                            System.out.println("Thanks for using over app");
                            break;
                        } else {
                            //throw new IllegalArgumentException("Please provide right Postal code");
                            System.err.println("This Postal code isn't from Germany!");
                        }
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

}
