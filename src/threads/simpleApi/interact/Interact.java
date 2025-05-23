package threads.simpleApi.interact;

import java.util.Collection;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Interact {
    static int count;

    public static void main(String... args) throws InterruptedException {
        Random random = new Random();

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        Runnable taskA = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    listA.add(random.nextInt(0, 50));
                }
            }
        };

        Thread threadA = new Thread(taskA);
        Thread threadB = new Thread(() -> listB.addAll(Stream.generate(() -> random.nextInt(0, 50)).limit(30).toList()));

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println(listA);
        System.out.println(listB);
        System.out.println("sum: " + Stream.of(listA, listB).flatMap(Collection::stream).mapToInt(x -> x).sum());

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
        });

        thread3.start();

        System.out.println("before join: " + count);

        thread3.join();

        System.out.println("after join: " + count);

        Thread threadLastButNotLeast = new Thread(() -> {
            int count = 0;
            while (true) {
                System.out.println("Ausgabe ---> " + ++count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Last tread interrupted");
                    break;
                }
            }
        });

        threadLastButNotLeast.start();

        Thread.sleep(5000);

        threadLastButNotLeast.interrupt();
    }
}
