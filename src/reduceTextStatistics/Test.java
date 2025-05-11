package reduceTextStatistics;

import java.util.Optional;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

class TextStatisticsImpl implements TextStatistics {
  private String text;

  TextStatisticsImpl() {
  }

  TextStatisticsImpl(String text) {
    this.text = text;
  }

  void setText(String text) {
    if (this.text == null) {
      this.text = text;
    } else {
      this.text += text;
    }
  }

  String getText() {
    return this.text;
  }

  public int getCountChars() {
    return (int) Stream.of(this.text.split("")).count();
  }

  public int getCountSpecialChars() {
    return Stream.of(this.text.split(""))
      .reduce(0, (a, b) -> {
        if (Pattern.matches("[!-/:-@\\[-`\\{-~]", b)) {
          return ++a;
        }
        return a;
      }, (x, y) -> x);
  }

  public int getCountLetters() {
    return (int) Stream.of(this.text.split(""))
      .filter(str -> Pattern.compile("[a-zA-Z]").matcher(str).find())
      .count();
  }

  public Optional<String> getLongestWord() {
    return Stream.of(this.text.split(" ")).max((a, b) -> a.length() - b.length());
  }
}

public class Test {
  public static void main(String... args) {
    var textStat = new TextStatisticsImpl("sdf@ rrtzzz");

    System.out.println("Chars count: " + textStat.getCountChars());
    System.out.println("Special chars count: " + textStat.getCountSpecialChars());
    System.out.println("Letters count: " + textStat.getCountLetters());
    System.out.print("Longest word: ");
    System.out.println(textStat.getLongestWord().isPresent() ? textStat.getLongestWord().get() : null);

    String[] input = {
      "String 1",
      "Heute ist Montag",
      "Java ist toll!",
      "s@metzrew&tzrew"
    };

    var idt = new TextStatisticsImpl();

    BinaryOperator<TextStatisticsImpl> acc1 = (x, y) -> {
      x.setText(y.getText());
      return x;
    };

    BiFunction<TextStatisticsImpl, String, TextStatisticsImpl> acc2 = (a, b) -> {
      a.setText(b + " ");
      return a;
    };
    BinaryOperator<TextStatisticsImpl> cmb = (a, b) -> a;

    Optional<TextStatisticsImpl> stats1 = Arrays.stream(input)
      .map(str -> new TextStatisticsImpl(str + " "))
      .reduce(acc1);

    TextStatistics stats2 = Arrays.stream(input)
      .map(str -> new TextStatisticsImpl(str + " "))
      .reduce(new TextStatisticsImpl(), acc1);

    TextStatistics stats3 = Arrays.stream(input).reduce(idt, acc2, cmb);

    if (stats1.isPresent()) {
      System.out.println("Chars count: (stats1) " + stats1.get().getCountChars());
      System.out.println("Special chars count: (stats1) " + stats1.get().getCountSpecialChars());
      System.out.println("Letters count: (stats1)" + stats1.get().getCountLetters());
      System.out.print("Longest word: (stats1)");
      System.out.println(stats1.get().getLongestWord().isPresent() ? stats1.get().getLongestWord().get() : null);
    }

    System.out.println("Chars count: (stats2) " + stats2.getCountChars());
    System.out.println("Special chars count: (stats2) " + stats2.getCountSpecialChars());
    System.out.println("Letters count: (stats2) " + stats3.getCountLetters());
    System.out.print("Longest word: (stats2) ");
    System.out.println(stats2.getLongestWord().isPresent() ? stats2.getLongestWord().get() : null);


    System.out.println("Chars count: (stats3) " + stats3.getCountChars());
    System.out.println("Special chars count: (stats3) " + stats3.getCountSpecialChars());
    System.out.println("Letters count: (stats3) " + stats3.getCountLetters());
    System.out.print("Longest word: (stats3) ");
    System.out.println(stats3.getLongestWord().isPresent() ? stats3.getLongestWord().get() : null);
  }
}
