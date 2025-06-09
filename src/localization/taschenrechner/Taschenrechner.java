package localization.taschenrechner;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.nio.file.Files;
import java.util.function.BinaryOperator;

public class Taschenrechner {
  private static final String transTextPath = "localization.taschenrechner.translations.text";
  private final static String transExPath = "localization.taschenrechner.translations.exceptions";

  public static void main(String[] args) {
    checkMainProperties();
    calculation();
  }

  private static void checkMainProperties() {
    try {
      var mainProps = ResourceBundle.getBundle("localization.taschenrechner.calculator");
      Locale.setDefault(Locale.of(mainProps.getString("lang")));
    } catch (MissingResourceException e) {
      var t = ResourceBundle.getBundle(Taschenrechner.transExPath);

      System.out.println(t.getString("missingResourceEx"));
      System.out.println("Pls choose app langugage, \"en\" or \"de\"");

      readUserLang();
    }
  }

  private static void readUserLang() {
    String userAnswer = new Scanner(System.in).nextLine();

    if (userAnswer.equals("de") || userAnswer.equals("en")) {
      try {
        Path mainPropsPath = Path.of("src/localization/taschenrechner/calculator.properties");
        Files.createFile(mainPropsPath);

        String userAnswerWithKey = "lang=" + userAnswer;
        Files.writeString(mainPropsPath, userAnswerWithKey);
      } catch (IOException e) {
        System.out.println(e.getMessage());
      } finally {
        Locale.setDefault(Locale.of(userAnswer));
      }
    } else {
      var transEx = ResourceBundle.getBundle(Taschenrechner.transExPath);

      System.err.println(transEx.getString("langSupports"));
      readUserLang();
    }
  }

  private static char readUserChar() {
    return new Scanner(System.in).nextLine().charAt(0);
  }

  private static void calculation() {
    ResourceBundle t = ResourceBundle.getBundle(Taschenrechner.transTextPath);
    ResourceBundle tEx = ResourceBundle.getBundle(Taschenrechner.transExPath);
    System.out.println("***" + t.getString("calculator") + "***");

    char repeat = t.getString("userLastQuestionAnswerPositive").charAt(0);

    while (repeat == t.getString("userLastQuestionAnswerPositive").charAt(0)) {
      System.out.print("1. " + t.getString("zahl") + ": ");
      double a = readUserNumber(1);

      System.out.print(t.getString("operator") + " (+, -, *, /): ");
      char operator = readUserChar();

      System.out.print("2. " + t.getString("zahl") + ": ");
      double b = readUserNumber(2);

      BinaryOperator<Double> op = null;

      switch (operator) {
        case '+':
          op = Double::sum;
          break;
        case '-':
          op = (n1, n2) -> n1 - n2;
          break;
        case '*':
          op = (n1, n2) -> n1 * n2;
          break;
        case '/':
          op = (n1, n2) -> n1 / n2;
          break;

        default:
          System.out.println(tEx.getString("notSupportedOperator") + " " + operator);
          continue;
      }

      double result = op.apply(a, b);
      System.out.println(t.getString("result") + " " + result);

      System.out.print(t.getString("tryAgain") + " ");
      repeat = readUserChar();
    }
  }

  private static double readUserNumber(int inputCount) {
    var t = ResourceBundle.getBundle(Taschenrechner.transTextPath);
    var tEx = ResourceBundle.getBundle(Taschenrechner.transExPath);

    try {
      return new Scanner(System.in).nextDouble();
    } catch (InputMismatchException e) {
      System.out.println(tEx.getString("inputMismatchEx"));
      System.out.print(inputCount + ". " + t.getString("zahl") + ": ");

      readUserNumber(inputCount);

      return 0.0;
    }
  }
}
