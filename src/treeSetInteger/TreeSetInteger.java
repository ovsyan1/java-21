package treeSetInteger;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Random;

public class TreeSetInteger {
  public static void main(String[] args) {
    Random r = new Random();

    NavigableSet<Integer> set = new TreeSet<>((a,b) -> b - a);

    for(int i = 0; i < 100; i++) {
      set.add(r.nextInt(1000));
    }

    System.out.println(set);

    System.out.println(set.subSet(900, true, 800, true));
  }
}
