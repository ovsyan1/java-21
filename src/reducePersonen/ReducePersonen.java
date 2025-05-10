package reducePersonen;

import java.util.List;
import java.util.Arrays;
import java.util.function.BinaryOperator;

class Person {
  private String vorname = "";
  private String nachname = "";

  Person() {
  }

  Person(String vorname, String nachname) {
    this.vorname = vorname;
    this.nachname = nachname;
  }

  String getVorname() {
    return this.vorname;
  }

  String getNachname() {
    return this.nachname;
  }

  void setVorname(String vorname) {
    this.vorname = vorname;
  }

  void setNachname(String nachname) {
    this.nachname = nachname;
  }

  @Override
  public String toString() {
    return this.vorname + " " + this.nachname;
  }
}

public class ReducePersonen {
  public static void main(String... args) {
    List<Person> list = Arrays.asList(
      new Person("Tom", "Patze"),
      new Person("Jerry", "Maus"),
      new Person("Alexander", "Poe")
    );

    BinaryOperator<Person> acc = (a, b) -> {
      var person = new Person();

      if (a.getVorname().compareTo(b.getVorname()) > 0) {
        person.setVorname(a.getVorname());
      } else {
        person.setVorname(b.getVorname());
      }
      if (a.getNachname().compareTo(b.getNachname()) > 0) {
        person.setNachname(a.getNachname());
      } else {
        person.setNachname(b.getNachname());
      }

      return person;
    };

    list.stream()
      .reduce(acc)
      .ifPresent(System.out::println);

    System.out.println("2: " + list.stream()
      .reduce(new Person(), acc));

    System.out.println("3: " + list.stream()
      .parallel()
      .reduce(new Person(), acc, acc));
  }
}
