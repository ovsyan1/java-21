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
    // String userAnswer = new Scanner(System.in).nextLine();
    // Path pathWithScanner = Path.of("src/localization/taschenrechner/calculator.properties");
    String userAnswer = System.console().readLine();
    Path pathWithConsole = Path.of("localization/taschenrechner/calculator.properties");

    if (userAnswer.equals("de") || userAnswer.equals("en")) {
      try {
        Files.createFile(pathWithConsole);

        String userAnswerWithKey = "lang=" + userAnswer;
        Files.writeString(pathWithConsole, userAnswerWithKey);
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

  private static char readUserChar(EUserAnswerType answerType) {
    ResourceBundle t = ResourceBundle.getBundle(Taschenrechner.transTextPath);
    ResourceBundle tEx = ResourceBundle.getBundle(Taschenrechner.transExPath);
    char[] possibleUserAnswers = {'+', '-', '*', '/'};

    char userAnswer = new Scanner(System.in).nextLine().charAt(0);

    if (answerType.equals(EUserAnswerType.LITERAL)) {
      char positiveAnswer = t.getString("userLastQuestionAnswerPositive").charAt(0);
      char negativeAnswer = t.getString("userLastQuestionAnswerNegative").charAt(0);

      if (userAnswer == positiveAnswer || userAnswer == negativeAnswer) {
        return userAnswer;
      } else {
        System.out.println(tEx.getString("plsProvideExactlyChars"));
        return readUserChar(answerType);
      }
    } else if (answerType.equals(EUserAnswerType.MATH)) {
      for (char possibleUserAnswer : possibleUserAnswers) {
        if (userAnswer == possibleUserAnswer) {
          return userAnswer;
        }
      }

      System.out.println(tEx.getString("notSupportedOperator") + " " + userAnswer);
      System.out.print(t.getString("operator") + " (+, -, *, /): ");

      return readUserChar(answerType);
    } else {
      return 0;
    }
  }

  private static void calculation() {
    ResourceBundle t = ResourceBundle.getBundle(Taschenrechner.transTextPath);
    ResourceBundle tEx = ResourceBundle.getBundle(Taschenrechner.transExPath);
    System.out.println("***" + t.getString("calculator") + "***");

    char repeat = t.getString("userLastQuestionAnswerPositive").charAt(0);

    while (repeat == t.getString("userLastQuestionAnswerPositive").charAt(0)) {
      System.out.print("1. " + t.getString("zahl") + ": ");
      double firstInput = readUserNumber(1);

      System.out.print(t.getString("operator") + " (+, -, *, /): ");
      char operator = readUserChar(EUserAnswerType.MATH);

      System.out.print("2. " + t.getString("zahl") + ": ");
      double secondInput = readUserNumber(2);

      BinaryOperator<Double> op;

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

      double result = op.apply(firstInput, secondInput);
      System.out.println(t.getString("result") + " " + result);

      System.out.print(t.getString("tryAgain") + " ");
      repeat = readUserChar(EUserAnswerType.LITERAL);
    }
  }

  private static double readUserNumber(int inputCount) {
    ResourceBundle t = ResourceBundle.getBundle(Taschenrechner.transTextPath);
    ResourceBundle tEx = ResourceBundle.getBundle(Taschenrechner.transExPath);

    try {
      return new Scanner(System.in).nextDouble();
    } catch (InputMismatchException e) {
      System.out.println(tEx.getString("inputMismatchEx"));
      System.out.print(inputCount + ". " + t.getString("zahl") + ": ");

      return readUserNumber(inputCount);
    }
  }
}
