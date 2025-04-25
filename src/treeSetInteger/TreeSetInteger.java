package treeSetInteger;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Random;

public class TreeSetInteger {
  public static void main(String[] args) {
    Random r = new Random();

    NavigableSet<Integer> set = new TreeSet<>();

    for(int i = 0; i < 100; i++) {
      set.add(r.nextInt(1000));
    }

    System.out.println(set.descendingSet());

    System.out.println(set.subSet(800, true, 900, true));
  }
}
