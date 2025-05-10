package reduceSimple;

import java.util.stream.Stream;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ReduceSimple {
  public static void main(String... args) {
    String[] items = { "aa", "bbb", "cccc", "ddddd" };

    // A1
    int lengthOfItems = Stream.of(items).map(String::length).reduce(0, Integer::sum);
    System.out.println("Length of items: " + lengthOfItems);

    // A2
    int lengthOfItemsViaCombiner = Stream.of(items)
      .parallel()
      .reduce(0, (a, b) -> a + b.length(), Integer::sum);
    System.out.println("Length of items via combiner: " + lengthOfItemsViaCombiner);

    //A3
    Integer[] array = { 0, 0, 1, 0, 1, 0 };

   String identity = "";
   BiFunction<String, Integer, String> accumulator = (a, b) -> a + b;
   BinaryOperator<String> combiner = (c, d) -> c + d;
    // hier identity, accumulator und combiner definieren

    String s = Stream.of(array)
      .reduce(identity, accumulator, combiner);

    System.out.println(s); // 001010
  }
}
