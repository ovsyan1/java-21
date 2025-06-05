package threads.simpleApi.cyclicBarirerRaceCar;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String... unused) throws InterruptedException {
        List<RaceCar> finish = new CopyOnWriteArrayList<>();

        CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            AtomicInteger carPosition = new AtomicInteger(1);
            System.out.println();

            finish.forEach(car -> {
                System.out.print(carPosition.getAndIncrement() + " ");
                System.out.println(car);
            });
        });

        var t1 = new Thread(new RaceCar("Mazda", finish, barrier));
        var t2 = new Thread(new RaceCar("BMW", finish, barrier));
        var t3 = new Thread(new RaceCar("ZAZ", finish, barrier));
        var t4 = new Thread(new RaceCar("Toyota", finish, barrier));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Finish!");
    }
}
