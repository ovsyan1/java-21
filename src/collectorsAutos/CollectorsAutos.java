package collectorsAutos;

import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

class Auto {
  private final String hersteller, modell;

  Auto(String hersteller, String modell) {
    this.hersteller = hersteller;
    this.modell = modell;
  }

  public String getHersteller() {
    return hersteller;
  }

  public String getModell() {
    return modell;
  }

  public String toString() {
    return hersteller + "/" + modell;
  }
}

public class CollectorsAutos {
  public static void main(String... args) {
    List<Auto> autos = Arrays.asList(
      new Auto("VW", "Golf"),
      new Auto("VW", "Polo"),
      new Auto("Opel", "Corsa"),
      new Auto("Opel", "Astra")
    );

    Collector<String, ?, Set<String>> downstream = Collectors.toSet();
    Function<Auto, String> mapper = Auto::getHersteller;

    Collector<Auto, ?, Set<String>> collector
      = Collectors.mapping(mapper, downstream);

    Set<String> set = autos.stream().collect(collector);
    System.out.println(set); // mögliche Ausgabe: [VW, Opel]

    Map<String, List<Auto>> map = autos.stream().collect(Collectors.groupingBy(Auto::getHersteller));
    System.out.println(map);
    // mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}

    Map<String, List<String>> map1 = autos.stream()
      .collect(Collectors.groupingBy(Auto::getHersteller, Collectors.mapping(Auto::getModell, Collectors.toList())));
    System.out.println(map1);
    // mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}

    Map<String, List<Auto>> map2 = autos.stream()
      .collect(Collectors.groupingBy(Auto::getHersteller, TreeMap::new, Collectors.toList()));
    System.out.println(map2);
    // Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}

    Map<Boolean, List<Auto>> map3 = autos.stream()
      .collect(Collectors.partitioningBy(auto -> auto.getModell().contains("o")));

    map3.forEach((v, k) -> System.out.println(v + " " + k));
  }
}
