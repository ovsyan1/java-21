package threads.simpleApi.cyclicBarirerRaceCar;

import java.util.List;

public class Test {
    static List<RaceCar> list;
    public static void main(String... unused) {
        for(int i = 0; i < 4; i++) {
            new Thread(new RaceCar("Mazda", list)).start();
        }
    }
}
