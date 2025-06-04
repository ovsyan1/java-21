package threads.simpleApi.forkJoinMitEinemArray;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMitEinemArray {
    public static void main(String... unused) {
        int[] arr1 = ThreadLocalRandom.current().ints(-50, 51).limit(20).toArray();
        int[] arr2 = ThreadLocalRandom.current().ints(-50, 51).limit(20).toArray();
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
