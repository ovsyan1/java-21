package saveLoadArray;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class SaveLoadArray {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
//        Console cs = System.console();
//        if(cs == null) {
//            System.out.println("Unable to fetch console");
//            return;
//        }
        System.out.println("Wollen Sie einen int-array entweder erzeugen oder laden ?");

//        String aufgabe = cs.readLine();
        String aufgabe = sc.next();

        if (aufgabe.equalsIgnoreCase("erzeugen")) {
            System.out.println("Wie groß das Array sein soll ?(Tippen Sie bitte nur Ziffern)");

//            String arrayLength = cs.readLine();
            String arrayLength = sc.next();
            int[] arr1 = createArray(Integer.parseInt(arrayLength), -20, 20);

            System.out.println("Wie die Datei heißen soll ?");
//            String fileName = cs.readLine();
            String fileName = sc.next();
            saveArray(arr1, "src/saveLoadArray/" + fileName + ".txt");

            int[] arr2 = loadArray("src/saveLoadArray/" + fileName + ".txt");

            Arrays.stream(arr1).forEach(System.out::println);
            System.out.println("***********");
            Arrays.stream(arr2).forEach(System.out::println);

            System.out.println(arrayLength);
        }

        if (aufgabe.equalsIgnoreCase("laden")) {
            System.out.println("Wie die Datei heißt?");

//            String fileName = cs.readLine();
            String fileName = sc.next();

            int[] arr = loadArray("src/saveLoadArray/" + fileName + ".txt");

            Arrays.stream(arr).forEach(System.out::println);
        }

        System.out.println("THE END");
    }

    static int[] loadArray(String fileName) {
        int count = 0;
        int countOfRandomNumbers = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.readLine() != null) {
                countOfRandomNumbers++;
            }
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        int[] arr = new int[countOfRandomNumbers];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arr[count] = Integer.parseInt(line);
                count++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return arr;
    }

    static void saveArray(int[] array, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (int i : array) {
                bufferedWriter.write(Integer.toString(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    static int[] createArray(int len, int min, int max) {
        int[] arr = new int[len];

        Random random = new Random();

        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(min, max);
        }

        return arr;
    }
}
