package threads.simpleApi.cyclicBarirerRaceCar;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class RaceCar implements Runnable {
    private final String name;
    private final List<RaceCar> finish;
    private final CyclicBarrier barrier;

    public RaceCar(String name, List<RaceCar> finish, CyclicBarrier barrier) {
        this.name = name;
        this.finish = finish;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(name + " started.");

        try {
            System.out.println(name + " finished.");
            finish.add(this);
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return this.name;
    }
}
