package nestedPredicatePersonen;

import java.util.function.Predicate;

public final class TopLevelKlasse implements Predicate<Person> {
  @Override
  public boolean test(Person value) { return value.geburtsjahr() == 1997; };
}
