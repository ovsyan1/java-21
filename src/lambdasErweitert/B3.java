package lambdasErweitert;

import java.util.function.Function;

public class B3 {
  public static void main(String... args) {
    Function<String, Function<String, String>> ref = x -> y -> x;

    System.out.println(ref.apply("Moin").apply("Chao"));

    Function<Integer, Function<Integer, Integer>> ref2 = new Function<>() {
      @Override
      public Function<Integer, Integer> apply(Integer val) {
        // return (i) -> i; // 3
        return i -> val; // 5
      }
    };

    System.out.println(ref2.apply(5).apply(3));
  }
}
