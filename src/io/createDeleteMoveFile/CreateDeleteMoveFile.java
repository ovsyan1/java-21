package io.createDeleteMoveFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

public class CreateDeleteMoveFile {
  public static void main(String... args) {
    String rootName = "src/io";
     createFiles(rootName, "file", "txt", 2);
     // moveFiles(rootName, "src/io/folderForFiles", "txt");
     // deleteFiles(rootName, "txt");
  }

  static void createFiles(String rootName, String prefix, String extension, int count) {
    for (int i = 1; i <= count; i++) {
      String fileName = String.format(prefix + "%03d." + extension, i); // s = "file012.txt"
      try {
        Files.createFile(Path.of(rootName + "/" + fileName));
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  static void moveFiles(String sourceRootName, String targetRootName, String extension) {
    boolean isTargetDirectoryExists = Files.exists(Path.of(targetRootName));
    File folder = new File(sourceRootName);
    File[] listOfFiles = folder.listFiles();

    if(!isTargetDirectoryExists) {
      try {
        Files.createDirectory(Path.of(targetRootName));
      } catch (IOException e) {
        System.out.println("ex: " + e.getMessage());
      }

    }

    assert listOfFiles != null;
    for (File file : listOfFiles) {
      if (file.toString().endsWith(extension)) {
        try {
          Files.move(file.toPath(), Path.of(targetRootName + "/" + file.toPath().getFileName()));
        } catch (IOException e) {
          System.out.println("ex: " + e.getMessage());
        }
      }
    }
  }

  static void deleteFiles(String rootName, String extension) {
    File folder = new File(rootName);
    File[] listOfFiles = folder.listFiles();

    assert listOfFiles != null;
    for (File file : listOfFiles) {
      if (file.toString().endsWith(extension)) {
        try {
          Files.delete(file.toPath());
        } catch (IOException e) {
          System.out.println("ex: " + e.getMessage());
        }
      }
    }
  }
}
