package io.serialisierenDienste;

import java.io.*;

public class Test {
  public static void main(String... args) {
    String fileName = "sManager.bin";
    SpeicherManager sManager = new SpeicherManager(2000, new Defragmentierung(3000, "C:\\"));

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
      oos.writeObject(sManager);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }

    System.out.println(sManager);

    SpeicherManager sManager2 = null;

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream((fileName)))) {
      sManager2 = (SpeicherManager) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    System.out.println(sManager2);
  }
}
