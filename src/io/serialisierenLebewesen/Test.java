package io.serialisierenLebewesen;

import java.io.*;

public class Test {
  public static void main(String... args) throws IOException, ClassNotFoundException {
    String fileName = "src/io/serialisierenLebewesen/hund.txt";
    Hund h = new Hund(2, "Max", new Mensch("Otto", "Meyer"));

    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
      oos.writeObject(h);
    }

    Hund h2 = null;

    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
      h2 = (Hund) ois.readObject();
    }

    System.out.println(h2);
  }
}
