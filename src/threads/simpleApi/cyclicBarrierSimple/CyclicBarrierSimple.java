package threads.simpleApi.cyclicBarrierSimple;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierSimple {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String... unused) {
        int parties = 2;
        int barrier = 1_000_000;
        CyclicBarrier c1 = new CyclicBarrier(parties, () -> {
            if(parties * barrier == count.get()) {
                System.out.println(count.get());
            }
        });

        Runnable task = () -> {
            for (int i = 0; i < barrier; i++) {
                try {
                    count.incrementAndGet();
                    c1.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(task).start();
        new Thread(task).start();
    }
}
