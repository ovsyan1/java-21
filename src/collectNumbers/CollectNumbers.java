package collectNumbers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiConsumer;

public class CollectNumbers {
    public static void main(String... args) {
        String[] arr = {
                "1,2,3,4,5",
                "7,6,5,4,3",
                "123,456",
        };

        List<Integer> list;

        BiConsumer<List<Integer>, List<Integer>> cmb = List::addAll;
        list = Arrays.stream(arr)
                .map((str) -> Arrays.stream(str.split(",")).map(Integer::valueOf).toList())
                .flatMap(List:: stream)
                .filter(a -> a % 2 == 0)
                .parallel()
                .collect(ArrayList::new, List::add, cmb);


        System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]
    }
}
