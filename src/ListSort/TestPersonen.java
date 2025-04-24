package ListSort;

import java.util.*;

record Person(String vorname, String nachname) {
}

public class TestPersonen {
  public static void main(String[] args) {
    Person[] personenArr = {
      new Person("Paul", "Smith"),
      new Person("Paul", "Black"),
      new Person("John", "Smith"),
      new Person("John", "Black")
    };
    List<Person> personenList = new ArrayList<>(Arrays.asList(personenArr));

    System.out.println("Array");
    for (Person p : personenList) {
      System.out.print(p);
    }
    System.out.println("\n---------------");

    System.out.println("List");
    System.out.println(personenList);
    System.out.println("\n---------------");

    // Comparator<Person> comp2 = Comparator.comparing(Person::nachname).thenComparing(Person::vorname); // danke intellij idea, leider zu früh :)
    Comparator<Person> comp = (a, b) -> a.nachname().compareTo(b.nachname()) == 0 ? a.vorname().compareTo(b.vorname()) : a.nachname().compareTo(b.nachname());

    Arrays.sort(personenArr, comp);

    System.out.println("sorted Array");
    for (Person p : personenArr) {
      System.out.print(p);
    }

    System.out.println("\n---------------");

    Collections.sort(personenList, comp);
    System.out.println("sorted List");
    System.out.println(personenList);

    System.out.println("\n---------------");

    Arrays.sort(personenArr, comp.reversed());

    System.out.println("reverse sorted Array");
    for (Person p : personenArr) {
      System.out.print(p);
    }

    System.out.println("\n---------------");

    Collections.sort(personenList, comp.reversed());
    System.out.println("reverse sorted List");
    System.out.println(personenList);
  }
}
