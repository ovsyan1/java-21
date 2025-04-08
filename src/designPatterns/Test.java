package designPatterns;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        useMyValues(new MyValues(Arrays.asList(1, 2, 3)));
    }

    public static void useMyValues(MyValues mv) {
        System.out.println(mv);

        List<Integer> values = mv.getValues();
        values.add(7);
        System.out.println(values);

        System.out.println(mv.addToEachValue(1)); // Liefert das angepasste MyValues zurück

        System.out.println(mv);
    }
}
