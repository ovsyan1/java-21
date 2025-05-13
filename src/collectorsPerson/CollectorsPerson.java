package collectorsPerson;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;

class Person implements Comparable<Person> {
  private final String name;
  private final String beruf;

  Person(String name, String beruf) {
    this.name = name;
    this.beruf = beruf;
  }

  String getName() {
    return this.name;
  }

  String getBeruf() {
    return this.beruf;
  }

  @Override
  public int compareTo(Person p) {
    return this.name.compareTo(p.name);
  }


  @Override
  public String toString() {
    return this.name;
  }
}

public class CollectorsPerson {
  public static void main(String[] args) {
    Person[] personen = {
      new Person("Tom", "Bauarbeiter(in)"),
      new Person("Jerry", "Lehrer(in)"),
      new Person("Peter", "Metzger(in)"),
      new Person("Paul", "Bauarbeiter(in)"),
      new Person("Mary", "Lehrer(in)"),
    };

    TreeSet<Person> personsTreeSet = Arrays.stream(personen).collect(Collectors.toCollection(TreeSet::new));
    System.out.println(personsTreeSet);

    Map<String, String> personsMap = Arrays.stream(personen)
      .collect(Collectors.toMap(Person::getName, Person::getBeruf));
    personsMap.entrySet().forEach(System.out::println);

    Set<String> personsSet = Arrays.stream(personen)
      .collect(Collectors.mapping(x -> x.getBeruf(), Collectors.toSet()));
    System.out.print(personsSet);
    System.out.println();

    Map<String, List<Person>> personsGroupedMap = Arrays.stream(personen)
      .collect(Collectors.groupingBy(Person::getBeruf));
    personsGroupedMap.entrySet().forEach(System.out::println);

    Map<Boolean, List<Person>> bauarbeiter = Arrays.stream(personen)
      .collect(Collectors.partitioningBy(x -> x.getBeruf().equals("Bauarbeiter(in)")));
    System.out.print(bauarbeiter.get(true));
  }
}
