package reduceTextStatistics;

import java.util.Optional;

class TextStatisticsImpl implements TextStatistics {
  private String text;

  TextStatisticsImpl(String text) {
    this.text = text;
  }

  public int getCountChars() {
    return this.text.length();
  }

  public int getCountSpecialChars() {
    return 0;
  }

  public int getCountLetters() {
    return 0;
  }

  public Optional<String> getLongestWord() {
    return Optional.of("");
  }
}

public class Test {
  public static void main(String... args) {
    var textStat = new TextStatisticsImpl("qwerty");

    System.out.println(textStat.getCountChars());
  }
}
