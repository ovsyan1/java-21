package collectionsFunctional;

import java.util.*;

public class Test {
  public static void main(String... args) {
    Collection<Integer> coll = Arrays.asList(1, 2, 3, 4, 5);
    coll.forEach(System.out::print);

    System.out.println();

    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    list.removeIf((item) -> item % 2 == 0);
    System.out.println(list);

    List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    list2.replaceAll((item) -> item * 2);
    System.out.println(list2);

    List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    Comparator<Integer> comp = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    };
    // list3.sort(comp);
    // list3.sort((a, b) -> b - a);
    list3.sort(Comparator.comparing(Integer::intValue).reversed());
    System.out.println(list3);

    List<Integer> list4 = new ArrayList<>(Arrays.asList(1, null, 3, 4, 5, 6, 7, 8, 9, 10));
    int sum = 0;
    for(Integer i : list4) {
      if(i != null && !list4.isEmpty()) {
        sum += i;
      }
    }
    System.out.println(sum);
    // System.out.println(list4.stream().mapToInt(Integer::intValue).sum());
    System.out.println(list4.isEmpty() ? 0 : list4.parallelStream().filter(Objects::nonNull).reduce(Integer::sum).get());
  }
}
