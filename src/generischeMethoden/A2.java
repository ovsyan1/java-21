package generischeMethoden;

import java.util.function.Supplier;

public class A2 {
  private static <T extends Throwable> void checkAndThrow(boolean check, Supplier<T> s) throws T {
    if (!check) {
      throw s.get();
    }
  }

  void setValue(int value) {
    checkAndThrow(value > 0, IllegalArgumentException::new);
  }

  void writeValue(int value) {
    // checkAndThrow(value > 0, java.io.IOException::new); // cf because of checked IOException
  }
}
