package threads.simpleApi.executorService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordsReader {
    private WordsReader() {}

    public static List<String> getWords(String path) {
        List<String> listOfWords = new ArrayList<>();

        try (Scanner wordsScanner = new Scanner(new FileReader(path))) {
            while (wordsScanner.hasNext()) {
                listOfWords.add(wordsScanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listOfWords;
    }
}
