package lambdasErweitert;

import java.util.function.Consumer;

public class B0 {
  public static void main(String[] args) {
    class C1 implements Consumer<Integer> {
      @Override
      public void accept(Integer t) {
        System.out.println(t);
      }
    }

    Consumer<Integer> c1 = new C1();
    c1.accept(12);

    Consumer<Integer> c2 = new Consumer<>() {
      @Override
      public void accept(Integer t) {
        System.out.println(t);
      }
    };
    c2.accept(12);

    Consumer<Integer> c3 = (Integer x) -> System.out.println(x);
    c3.accept(12);

    Consumer<Integer> c4 = x -> System.out.println(x);
    c4.accept(12);
  }
}
