package abfahrZeiten;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.time.LocalTime;

public class AbfahrtZeiten {
  public static void main(String[] args) {
    NavigableSet<LocalTime> set = new TreeSet<>();

    int hour = 6;
    int minute = 12;

    do {
      set.add(LocalTime.of(hour, minute));

      minute += 20;

      if (minute > 52) {
        hour++;
        minute = 12;
      }

    } while (hour <= 23);

    System.out.println(set);

    System.out.println(set.higher(LocalTime.of(12, 3)));
    System.out.println(set.lower(LocalTime.of(12, 3)));
    System.out.println(set.ceiling(LocalTime.of(17, 12)));
    System.out.println(set.higher(LocalTime.of(17, 12)));
    System.out.println(set.subSet(LocalTime.of(12, 0), true, LocalTime.of(13, 0), true));
    System.out.println(set.subSet(LocalTime.of(11, 52), false, LocalTime.of(13, 12), true));
    System.out.println(set.first());
    System.out.println(set.last());
  }
}
