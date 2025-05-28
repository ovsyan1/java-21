package threads.simpleApi.philosophenProblem;

import java.util.List;
import java.util.stream.Stream;

public class PhilosophenProblem {
  public static void main(String... args) {
    int anzahlPhilosophen = 2;

    List<Philosoph> philosophen = getPhilosophen(anzahlPhilosophen);

    List<Object> gabeln = Stream.generate(Object::new)
      .limit(anzahlPhilosophen)
      .toList();

    for (int i = 0; i < anzahlPhilosophen; i++) {
      Object linkeGabel = gabeln.get(i);

      int indexRechteGabel = (i == anzahlPhilosophen - 1) ? 0 : i + 1;
      Object rechteGabel = gabeln.get(indexRechteGabel);

      Philosoph p = philosophen.get(i);
      p.setLinkeGabel(linkeGabel);
      p.setRechteGable(rechteGabel);
    }

    philosophen.stream().map(Thread::new).forEach(Thread::start);
  }

  static List<Philosoph> getPhilosophen(int anzahl) {
    String[] names = {"Gaston", "Karl", "William", "Michel", "Epiktet", "Simone de Beauvoir", "Niccolò"};

    return Stream.of(names).map(Philosoph::new).limit(anzahl).toList();
  }
}
