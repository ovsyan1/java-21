package threads.simpleApi.executorServiceSimple;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

public class ExecutorServiceSimple {
    public static void main(String... unused) {
        Random rnd = new Random();
        Runnable task1 = () -> Stream.generate(rnd::nextDouble).limit(10).forEach(System.out::println);

        ExecutorService service1 = Executors.newSingleThreadExecutor();
        service1.execute(task1);
        service1.shutdown();

        Callable<Double> task2 = new Callable<>() {
            @Override
            public Double call() throws Exception {
                return Stream.generate(rnd::nextDouble).limit(10).flatMapToDouble(DoubleStream::of).sum();
            }
        };
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        Future<Double> future = service2.submit(task2);

        try {
            System.out.println("A2 sum: " + future.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        service2.shutdown();


        try(ExecutorService service3 = Executors.newSingleThreadExecutor()) {
            List<Future<Integer>> list = new ArrayList<>();
            for(int i = 0; i < 100; i++) {
                Callable<Integer> task = () -> rnd.nextInt(1, 10);
                list.add(service3.submit(task));
            }

            int sum = list.stream().flatMapToInt(x -> {
                try {
                  return  IntStream.of(x.get());
                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).sum();

            System.out.println("A3 sum: " + sum);
        }
    }
}
