package stringTransformFunction;

import java.util.function.Function;
import java.util.*;

public class StringTransform {
  private String value;
  private static final List<Function<String, String>> list = new ArrayList<>();

  public StringTransform addTransformation(Function<String, String> func) {
    list.add(func);

    return this;
  }

  public String process(String val) {
    var result = val;

    for(Function<String, String> func : list) {
      result = func.apply(result);
    }

    this.value = result;
    return this.value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
