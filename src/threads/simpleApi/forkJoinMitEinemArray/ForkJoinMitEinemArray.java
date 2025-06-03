package threads.simpleApi.forkJoinMitEinemArray;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMitEinemArray {
    public static void main(String... unused) {
        int[] arr1 = Stream.generate(() -> ThreadLocalRandom.current().nextInt(-50, 51)).limit(20).flatMapToInt(IntStream::of).toArray();
        int[] arr2 = Stream.generate(() -> ThreadLocalRandom.current().nextInt(-50, 51)).limit(20).flatMapToInt(IntStream::of).toArray();
        System.out.println("First array before compute: " + Arrays.toString(arr1));

        try (ForkJoinPool pool = new ForkJoinPool()) {
            pool.invoke(new MyRecursiveAction(arr1, 0, arr1.length));
            System.out.println("First array after compute: " + Arrays.toString(arr1));
            System.out.println();

            System.out.println("Second array: " + Arrays.toString(arr2));
            System.out.println("Count of negative numbers: " + pool.invoke(new MyRecursiveTask(arr2, 0, arr2.length)));
        }

    }
}
