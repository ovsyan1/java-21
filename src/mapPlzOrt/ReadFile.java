package mapPlzOrt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

class ReadFile extends MyScanner {
    ReadFile(Map<String, String> postalCodes) {
        super(postalCodes);
    }

    void read(String path) {
        try (Scanner sc = new Scanner(new File(path))) {
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split("\t");

                if (parts.length == 2) {
                    String postalCode = parts[0].replace("\"", "");
                    String city = parts[1].replace("\"", "");

                    postalCodes.put(postalCode, city);
                } else {
                    System.out.println("Unexpected format.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}
