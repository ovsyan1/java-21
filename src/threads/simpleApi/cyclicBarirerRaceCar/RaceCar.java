package threads.simpleApi.cyclicBarirerRaceCar;

import java.util.List;

class RaceCar implements Runnable {
    private String name;
    private List<RaceCar> finish;

    public RaceCar(String name, List<RaceCar> finish) {
        this.name = name;
        this.finish = finish;
    }

    @Override
    public void run() {
        System.out.println(name + " started.");

        finish.add(this);
        System.out.println(name + " finished.");
    }
    @Override
    public String toString() {
        return name;
    }
}
