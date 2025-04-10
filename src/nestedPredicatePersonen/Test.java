package nestedPredicatePersonen;

import java.time.Year;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;

public class Test {
  static class InnereKlasse implements Predicate<Person> {
    @Override
    public boolean test(Person value) {
      return value.nachname().contains("a");
    }
  }

  public static void main(String... args) {
    Test test = new Test();
    Person[] persons = new Person[4];

    for (int i = 0; i < persons.length; i++) {
      persons[i] = new Person("Florian" + (char) ('b' + i), "Ho" + (char) ('c' + i), 1996 + i);
    }
    persons[3] = new Person("Muha", "Hasuhaltow", 1999);

    List<Person> listOfPersons = test.filtern(persons, new TopLevelKlasse());
    System.out.println(listOfPersons);

    List<Person> listOfPersons2 = test.filtern(persons, new InnereKlasse());
    System.out.println(listOfPersons2);

    class LokaleKlasse implements Predicate<Person> {
      @Override
      public boolean test(Person value) {
        return value.nachname().length() > 3;
      }
    }

    List<Person> listOfPersons3 = test.filtern(persons, new LokaleKlasse());
    System.out.println(listOfPersons3);

    Predicate<Person> p = new Predicate<Person>() {
      @Override
      public boolean test(Person value) {
        return new TopLevelKlasse().test(value) && new InnereKlasse().test(value);
      }
    };

    List<Person> listOfPersons4 = test.filtern(persons, p);
    System.out.println(listOfPersons4);

    Predicate<Person> predicateLambda = x -> Year.isLeap(x.geburtsjahr());

    List<Person> listOfPersons5 = test.filtern(persons, predicateLambda);
    System.out.println(listOfPersons5);
  }

  List<Person> filtern(Person[] persons, Predicate<Person> predicate) {
    List<Person> listOfPersons = new ArrayList<>();

    for (Person person : persons) {
      if (predicate.test(person)) {
        listOfPersons.add(person);
      }
    }

    return listOfPersons;
  }
}

