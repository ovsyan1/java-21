package wordsStreams;

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordsStream {
  public static void main(String... args) throws IOException {
    Scanner wordsScanner = new Scanner(new FileReader("src/wordsStreams/english-words.txt"));
    Scanner passwordsScanner = new Scanner(new FileReader("src/wordsStreams/passwords.txt"));

    List<String> words = new ArrayList<>();
    List<String> passwords = new ArrayList<>();

    while(wordsScanner.hasNext()) {
      words.add(wordsScanner.next());
    }
    while(passwordsScanner.hasNext()) {
      passwords.add(passwordsScanner.next());
    }
    System.out.println("Default words length: " + words.size());
    System.out.println("Default password length: " + passwords.size());

    System.out.println("***** A1");
    System.out.println("Length more than 5: " + words.stream().filter(s -> s.length() > 5).count());

    System.out.println("***** A2");
    words.stream().filter(str -> str.charAt(0) == 'm').forEach(System.out::println);

    System.out.println("***** A3");
    words.stream().skip(20).limit(10).forEach(System.out::println);

    System.out.println("***** A4");
    words.stream().filter(str -> str.contains("ooo")).forEach(System.out::println);

    System.out.println("***** A5");
    LinkedList<String> linkedList = words.stream()
      .filter(str -> str.contains("aba"))
      .collect(Collectors.toCollection(LinkedList::new));
      //.collect(LinkedList::new,
      //  LinkedList::add,
      //  LinkedList::addAll
      //);
    System.out.println(linkedList);

    System.out.println("***** A6");
    passwords.stream().filter(password -> password.contains("qwerty")).forEach(System.out::println);

    System.out.println("***** A7");
    passwords.stream()
      .collect(
        Collectors.groupingBy(
          String::length,
          TreeMap::new,
          Collectors.toList()
        ))
      .forEach((k, v) -> System.out.println(k + " " + v));
  }
}
