package generischeMethoden;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class A4 {
  public static void main(String... aaa ) {
    Supplier<Collection<String>> supplier = ArrayList::new;

    System.out.println(build(supplier, "Haööp", "fff", "Comcave"));
  }
  @SafeVarargs
  public static <A, T extends Collection<A>> T build(Supplier<T> s, A... values) {
    T c = s.get();

    for (A a : values) {
      c.add(a);
    }

    return c;
  }

  // Um collection mit genau einem Typ zu basteln ?
}
