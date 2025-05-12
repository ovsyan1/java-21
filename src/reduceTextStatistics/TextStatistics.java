package reduceTextStatistics;

import java.util.Optional;

public interface TextStatistics {

  public int getCountChars();

  public int getCountSpecialChars();

  public int getCountLetters();

  public Optional<String> getLongestWord();
}
