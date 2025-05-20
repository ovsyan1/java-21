package io.createDeleteMoveFile.filesWalkSimple;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FilesWalkSimple {
  public static void main(String... args) throws IOException {
    var myRoot = Path.of("src/io/createDeleteMoveFile");

    System.out.println("Folders: ");
    printSubdirs(myRoot);

    System.out.println("Files: ");
    printFiles(myRoot);

    System.out.println("Empty folders: ");
    printEmptySubdirs(myRoot);
  }

  static void printSubdirs(Path dir) throws IOException {
    try (Stream<Path> paths = Files.list(dir)) {
      paths.filter(Files::isDirectory).forEach(System.out::println);
    }
  }

  static void printFiles(Path dir) throws IOException {
    try (Stream<Path> paths = Files.list(dir)) {
      paths.filter(Files::isRegularFile).forEach(System.out::println);
    }
  }

  static void printEmptySubdirs(Path dir) throws IOException {
    try (Stream<Path> files = Files.walk(dir)) {
      files.filter(Files::isDirectory).forEach(path -> {
        try(Stream<Path> paths = Files.list(path)) {
          if (paths.findAny().isEmpty()) {
            System.out.println(path + " size: " + Files.size(path));
          }
        } catch (IOException e) {
          throw new UncheckedIOException(e);
        }
      });
    }
  }
}
