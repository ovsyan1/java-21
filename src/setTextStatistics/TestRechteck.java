package setTextStatistics;

import java.util.Set;
import java.util.HashSet;

public class TestRechteck {
  public static void main(String[] args) {
    Set<Rechteck> set = new HashSet<>();

    Rechteck r = new Rechteck(20, 50);

    set.add(r);
    set.add(r);
    set.add(new Rechteck(10, 20));
    set.add(new Rechteck(10, 20));

    System.out.println(set);
  }
}
