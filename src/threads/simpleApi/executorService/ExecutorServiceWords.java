package threads.simpleApi.executorService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceWords {
    public static void main(String... unused) throws FileNotFoundException {
        WordsReader words = new WordsReader("src/threads/simpleApi/executorService/english-words.txt");
        System.out.println((long) words.getWords().size()); // false, check again this logic
        t2(words);
        t4(words);
        t6(words);
    }

    static void t6(WordsReader words) {
        int countOfTasks = 50;
        List<Callable<Long>> listofTasks = new ArrayList<>();

        for(int i = 0; i < countOfTasks; i++) {
            Callable<Long> task = () -> {
                System.out.print("Name of Thread: " + Thread.currentThread().getName() + " how many words was read ");
                return words.getWords().stream().filter(w -> w.length() > 5).count();
            };
            listofTasks.add(task);
        }

        try(ExecutorService service = Executors.newFixedThreadPool(countOfTasks)) {
            listofTasks.forEach((task) -> {
                long sum = 0;
                Future<Long> future = service.submit(task);
                try {
                    sum += future.get();
                    System.out.println(future.get());
                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Count all words in .txt file " + sum);
            });
        }
    }

    static void t4(WordsReader words) {
        Callable<Long> task = () -> words.getWords().stream().filter(w -> w.length() > 5).count();

        try(ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<Long> future = service.submit(task);

            try {
                System.out.println("Words longer than 5 " +future.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    static void t2(WordsReader words) {
        Runnable task1 = () -> System.out.println("Count words with letter 't' " + words.getWords().stream().filter(w -> w.toLowerCase().contains("t")).count());
        Callable<Long> task2 = () -> words.getWords().stream().filter(w -> w.toLowerCase().contains("oo")).count();

        try(ExecutorService service = Executors.newSingleThreadExecutor()) {
            service.execute(task1);
            Future<Long> future = service.submit(task2);

            try {
                System.out.println("Count words with letters 'oo' " +future.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
