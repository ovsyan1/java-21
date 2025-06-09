package localization.taschenrechner.translations;

import java.util.ListResourceBundle;

public class text_de extends ListResourceBundle {
  @Override
  protected Object[][] getContents() {
    return new Object[][] {
      {"calculator", "Tashenrechner"},
      {"zahl", "Zahl"},
      {"operator", "Operator"},
      {"result", "Ergebnis:"},
      {"tryAgain", "Nochmal? (j/n):"},
      {"userLastQuestionAnswerPositive", "j"},
      {"userLastQuestionAnswerNegative", "n"}
    };
  }
}
