package threads.simpleApi.executorService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class ExecutorServiceWords {
    public static void main(String... unused) throws FileNotFoundException {
        List<String> words = WordsReader.getWords("src/wordsStreams/english-words.txt");
        System.out.println("Original words size: " + (long) words.size());

        t4(words);
        t5(words);
        t6(words);
        t7(words);
    }

    static void t7(List<String> words) {
        int countOfThreads = 50;

        List<List<String>> lists = Helper.cutListOfWords(words, countOfThreads);

        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            List<Long> listOfSums = new ArrayList<>();

            lists.forEach((list) -> {
                Future<Long> future = service.submit(() -> list.stream().filter(w -> w.length() > 5).count());
                try {
                    listOfSums.add(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println("TASK 7 (SUM): " + listOfSums.stream().flatMapToLong(LongStream::of).sum());
        }
    }

    static void t6(List<String> words) {
        int countOfThreads = 50;

        List<List<String>> lists = Helper.cutListOfWords(words, countOfThreads);

        try (ExecutorService service = Executors.newFixedThreadPool(countOfThreads)) {
            lists.forEach((list) -> {
                Future<Long> future = service.submit(() -> list.stream().filter(w -> w.length() > 5).count());

                try {
                    System.out.println(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    static void t5(List<String> words) {
        Callable<Long> task = () -> words.stream().filter(w -> w.length() > 5).count();

        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<Long> future = service.submit(task);

            try {
                System.out.println("Words longer than 5(TASK 5, SUM) " + future.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    static void t4(List<String> words) {
        Runnable task1 = () -> System.out.println("Count words with letter 't' " + words.stream().filter(w -> w.toLowerCase().contains("t")).count());
        Callable<Long> task2 = () -> words.stream().filter(w -> w.toLowerCase().contains("oo")).count();

        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            service.execute(task1);
            Future<Long> future = service.submit(task2);

            try {
                System.out.println("Count words with letters 'oo' " + future.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
