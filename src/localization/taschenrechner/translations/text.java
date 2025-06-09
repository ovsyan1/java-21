package localization.taschenrechner.translations;

import java.util.ListResourceBundle;

public class text extends ListResourceBundle {
  @Override
  protected Object[][] getContents() {
    return new Object[][] {
      {"calculator", "Calculator"},
      {"zahl", "Number444"},
      {"operator", "Operator"},
      {"result", "Result:"},
      {"tryAgain", "Again? (y/n):"},
      {"userLastQuestionAnswerPositive", "y"},
      {"userLastQuestionAnswerNegative", "n"}
    };
  }
}