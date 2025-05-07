package streamIntermediateOperations;

import java.util.Random;
import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;

public class StreamIntermediateOperations {
  public static void main(String... args) {
    // A1
    List<Integer> list = Arrays.asList(13, 15, 17, 19, 21);
    list.stream()
      .filter(item -> item == 15 || item == 19)
      .forEach((item) -> System.out.println("Treffer: " + item));

    System.out.println("*************");
    // A2
    Integer[] array = {1, 4, 7, 3, -8};
    Arrays.stream(array).map(x -> x % 2 == 0 ? "gerade" : "ungerade").forEach(System.out::println);

    System.out.println("*************");
    // A3
    List<String> list3 = Arrays.asList("Tom", "Jerry", "Rex");
    list3.stream().map(Tier::new).forEach(System.out::println);

    System.out.println("*************");
    // A4
    Stream.generate(StreamIntermediateOperations::randomNumber)
      .filter(num -> num < -10 && num > -15)
      .map(Double::valueOf)
      .limit(30)
      .forEach(System.out::println);

    System.out.println("*************");
    // A5
    Tier[] array5 = {
      new Tier("Rex"),
      new Tier("Tom"),
      new Tier("Jerry"),
      new Tier("Tom"),
      new Tier("Jerry"),
    };

    Arrays.stream(array5).distinct().forEach(System.out::println);

    System.out.println("*************");
    // A6
    List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
    List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
    List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");

    Stream.of(mailsErsthelfer, mailsIT, mailsQM)
      .flatMap(List::stream)
      .map(email -> email.substring(0, email.indexOf('@')))
      .distinct()
      .forEach(System.out::println);
  }

  static int randomNumber() {
    return new Random().nextInt(-20, 21);
  }
}

class Tier {
  private String name;

  public Tier(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Tier t)) {
      return false;
    }
    return t.name.equals(this.name);
  }

  @Override
  public int hashCode() {
    return name.length();
  }

  @Override
  public String toString() {
    return "Tier " + name;
  }
}
