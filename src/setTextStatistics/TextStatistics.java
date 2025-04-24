package setTextStatistics;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
//import java.util.Arrays;

public class TextStatistics {
  private static String value;

  public static void main(String[] args) {
    TextStatistics stat = TextStatistics.of("Heute ist Montag!");

    System.out.println(stat.getUniqueChars());
  }

  static TextStatistics of(String s) {
    value = s;

    return new TextStatistics();
  }

  Collection<Character> getUniqueChars() {
    Set<Character> set = new HashSet<>();

    for(char c : value.toCharArray()) {
      set.add(c);
    }

    return set;
  }
}
