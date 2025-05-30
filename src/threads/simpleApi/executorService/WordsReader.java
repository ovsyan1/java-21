package threads.simpleApi.executorService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WordsReader {
    private final String path;
    private final List<String> listOfWords = new ArrayList<>();

    WordsReader(String path) {
        this.path = path;
    }

    List<String> getWords() {
        try (Scanner wordsScanner = new Scanner(new FileReader(this.path))) {
            while (wordsScanner.hasNext()) {
                this.listOfWords.add(wordsScanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return this.listOfWords;
    }
}
