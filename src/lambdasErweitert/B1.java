package lambdasErweitert;

import java.util.function.Supplier;

public class B1 {
  public static void main(String[] args) {
    class S1 implements Supplier<String> {
      @Override
      public String get() {
        return "Montag";
      }
    }

    Supplier<String> s1 = new S1();
    System.out.println("Heute ist " + s1.get());

    Supplier<String> s2 = new Supplier<String>() {
      @Override
      public String get() {
        return "Montag";
      }
    };
    System.out.println("Heute ist " + s2.get());

    Supplier<String> s3 = () -> {
      return "Montag";
    };
    System.out.println("Heute ist "+s3.get());

  Supplier<String> s4 = () -> "Montag";
    System.out.println("Heute ist "+s4.get());
}
}
