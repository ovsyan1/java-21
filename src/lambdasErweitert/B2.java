package lambdasErweitert;

import java.util.function.BiFunction;

public class B2 {
  public static void main(String[] args) {
    class F1 implements BiFunction<String, String, Integer> {
      @Override
      public Integer apply(String t1, String t2) {
        return t1.length() + t2.length();
      }
    }

    BiFunction<String, String, Integer> f1 = new F1();
    System.out.println(f1.apply("ab", "cde"));

    BiFunction<String, String, Integer> f2 = new BiFunction<>() {
      @Override
      public Integer apply(String s1, String s2) {
        return s1.length() + s2.length();
      }
    };
    System.out.println(f2.apply("ab", "cde"));

    BiFunction<String, String, Integer> f3 = (String s1, String s2) -> {
      return s1.length() + s2.length();
    };
    System.out.println(f3.apply("ab", "cde"));

    BiFunction<String, String, Integer> f4 = (s1, s2) -> s1.length() + s2.length();
    System.out.println(f4.apply("ab", "cde"));
  }
}
