package io.words;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Words {
  public static void main(String... args) {
    List<String> words = new ArrayList<>();

    try {
      words = Files.readAllLines(Path.of("src/io/words/germanWords.txt"));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    Path myDir = Path.of("src/io/words/mydir");
    String extension = "txt";

    if (!Files.exists(myDir)) {
      try {
        Files.createDirectories(myDir);
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }

    words.stream()
      .collect(Collectors.groupingBy(word -> word.toLowerCase().substring(0, 1)))
      .forEach((k, v) -> createFiles(myDir, k, v, extension));

    deleteFiles(myDir, extension);
  }

  static void createFiles(Path path, String key, List<String> words, String extension) {
    Path targetPath = path.resolve(key + "." + extension);
    try {
      Files.createFile(targetPath);
      Files.write(targetPath, words);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  static void deleteFiles(Path path, String extension) {
    try (Stream<Path> paths = Files.walk(path)) {
      paths.filter(x -> x.toString().endsWith(extension)).forEach(x -> {
        try {
          Files.delete(x);
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      });
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }
}
