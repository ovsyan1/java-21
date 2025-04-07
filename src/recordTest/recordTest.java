package recordTest;

import java.util.ArrayList;
import java.util.Arrays;

record R1(String name, int age) {}

public class recordTest {
    public static void main(String... args) {
        ArrayList<R1> list = new ArrayList<>(Arrays.asList(
                new R1("Kirill", 22),
                new R1("Ivan", 35),
                new R1("Elli", 5),
                new R1("Dima", 59)
        ));

        if(list.contains(new R1("Kirill", 22))) {
            list.remove(new R1("Kirill", 22));
        }

        System.out.println(list);
    }
}
