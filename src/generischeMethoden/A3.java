package generischeMethoden;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

public class A3 {
  public static void main(String... args) {
    System.out.println(sum(new ArrayList(Arrays.asList(5.8, 2, 3, 4, 5))));
  }

  public static <T extends Number> Integer sum(Collection<T> zahlen) {
    int sum = 0;

    for (T zahlRef : zahlen) {
      sum += zahlRef.intValue();
    }

    return sum;
  }
}
