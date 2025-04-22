package generischeMethoden;

import java.util.Random;
import java.util.Date;

public class A1 {
  public static void main(String... args) {
    String s = getRandom("abc", "def"); // getRandom liefert zufällig entweder "abc" oder "def"
    System.out.println(s);

    Integer i = getRandom(14, 12);
    System.out.println(i); // entweder 14 oder 12

    Date d = getRandom(new Date(), new Date(0));  // java.util.Date
    System.out.println(d);

    // String erg = getRandom("hallo", 22); // hier ensteht ein Compilerfehler
  }

  static <T> T getRandom(T a, T b) {
    return new Random().nextBoolean() ? a : b;
  }
}
