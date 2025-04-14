package stringTransformFunction;

public class Test {
  public static void main(String... args) {
    // Transformationen vordefinieren:
    StringTransform t1 = new StringTransform()
      .addTransformation(s -> s.toUpperCase())
      .addTransformation(s -> s + "!");

    // Transformationen durchführen:
    String s = t1.process("Hallo");
    System.out.println(s); // HALLO!

    // Transformationen mit einem anderen String durchführen:
    s = t1.process("Java ist toll");
    System.out.println(s); // JAVA IST TOLL!
  }
}
