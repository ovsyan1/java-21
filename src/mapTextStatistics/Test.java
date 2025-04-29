package mapTextStatistics;

import java.util.Collection;

public class Test {
    public static void main(String... args) {
        TextStatistics stat = TextStatistics.of("Heute ist Dienstag");

        Collection<Character> chars = stat.getUniqueChars();

        System.out.println(chars);

        System.out.println(stat.getCharCounts());
    }
}
