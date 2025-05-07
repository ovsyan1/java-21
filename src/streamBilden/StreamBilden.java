package streamBilden;

import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class StreamBilden {
  public static void main(String[] args) {
    // A1
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList(55, 77);


    Stream
      .of(list1, list2)
      .forEach(e -> System.out.println("size = " + e.size() + ". elements = " + e));

    System.out.println("************");

    // A2
    Stream.generate(StreamBilden::nextInt).limit(5).forEach(System.out::println);

    System.out.println("************");

    // A3

    int seed = 100;

    Stream.iterate(seed, (a) -> a >= 1, (a) -> --a)
      //.limit(100)
      .forEach(System.out::println);

    System.out.println("************");

    // A4
    String[] a1 = { "a", "b" };
    String[] a2 = { "c", "d" };

    Stream.concat(Arrays.stream(a1), Arrays.stream(a2)).forEach(System.out::println);

    System.out.println("************");

    // A5
    Stream.builder().add("/a").add("/a/b").add("/a/b/c").add("/a/b/c/d").build().forEach(System.out::println);
  }

  static Integer nextInt() {
    return new Random().nextInt();
  }
}
