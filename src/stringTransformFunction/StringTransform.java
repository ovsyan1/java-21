package stringTransformFunction;

import java.util.function.Function;
import java.util.*;

public class StringTransform {
  private String value;
  private final List<Function<String, String>> listOfTransformations = new ArrayList<>();

  public StringTransform addTransformation(Function<String, String> transformation) {
    listOfTransformations.add(transformation);

    return this;
  }

  public String process(String val) {
    var result = val;

    for(Function<String, String> transformation : listOfTransformations) {
      result = transformation.apply(result);
    }

    this.value = result;
    return this.value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
