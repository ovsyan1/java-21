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

    System.out.println("Empty files: ");
    printEmptySubdirs(myRoot);
  }

  static void printSubdirs(Path dir) throws IOException {
    try (Stream<Path> pathes = Files.list(dir)) {
      pathes.forEach(path -> {
        if (Files.isDirectory(path))
          System.out.println(path);
      });
    }
  }

  static void printFiles(Path dir) throws IOException {
    try (Stream<Path> pathes = Files.list(dir)) {
      pathes.forEach(path -> {
        if (Files.isRegularFile(path))
          System.out.println(path);
      });
    }
  }

  static void printEmptySubdirs(Path dir) throws IOException {
    try (Stream<Path> files = Files.walk(dir)) {
      files.forEach(path -> {
        try {
          if (Files.isRegularFile(path) && Files.size(path) == 0) {
            System.out.println(path + " size: " + Files.size(path));
          }
        } catch (IOException e) {
          throw new UncheckedIOException(e);
        }
      });
    }
  }
}
