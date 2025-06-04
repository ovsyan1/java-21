package threads.simpleApi.forkJoinList;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import threads.simpleApi.executorService.WordsReader;


public class ForkJoinList {
    public static void main(String... unused) {
        List<String> words = WordsReader.getWords("src/wordsStreams/english-words.txt");

        try (ForkJoinPool pool = new ForkJoinPool()) {
            pool.invoke(new MyRecursiveAction(words, 0, words.size()));
            System.out.println(pool.invoke(new MyRecursiveTask(words, 0, words.size())));
        }
    }
}
