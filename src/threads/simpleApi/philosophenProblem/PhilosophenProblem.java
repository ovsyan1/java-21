package threads.simpleApi.philosophenProblem;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;
import java.util.concurrent.locks.Lock;

public class PhilosophenProblem {
  public static void main(String... args) {
    int anzahlPhilosophen = 5;

    List<Philosoph> philosophen = getPhilosophen(anzahlPhilosophen);

    List<ReentrantLock> gabeln = Stream.generate(ReentrantLock::new)
      .limit(anzahlPhilosophen)
      .toList();

    for (int i = 0; i < anzahlPhilosophen; i++) {
      Lock linkeGabel = gabeln.get(i);

      int indexRechteGabel = (i == anzahlPhilosophen - 1) ? 0 : i + 1;
      Lock rechteGabel = gabeln.get(indexRechteGabel);

      Philosoph p = philosophen.get(i);
      p.setLinkeGable(linkeGabel);
      p.setRechteGabel(rechteGabel);
    }
  }

  static List<Philosoph> getPhilosophen(int anzahl) {
    String[] names = {"Gaston", "Karl", "William", "Michel", "Epiktet", "Simone de Beauvoir", "Niccolò"};

    return Stream.of(names).map(name -> new Philosoph(name, new ReentrantLock())).limit(anzahl).toList();
  }
}
