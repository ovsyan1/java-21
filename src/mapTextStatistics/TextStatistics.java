package mapTextStatistics;

import java.util.*;

class TextStatistics {
    static String value;

    private TextStatistics(){}

     static TextStatistics of(String str) {
        value = str;

        return new TextStatistics();
    }

    Collection<Character> getUniqueChars() {
        Set<Character> set = new HashSet<>();

        for(char ch : value.toCharArray()) {
            set.add(ch);
        }

        return set;
    }

    Map<Character, Integer> getCharCounts() {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : value.toCharArray()) {
                map.compute(ch, (key, oldVal) -> oldVal != null ? ++oldVal : 1);
            // map.merge(ch, 1, (oldVal, newVal) -> ++oldVal);    // { =2, a=1, s=2, D=1, t=3, u=1, e=3, g=1, H=1, i=2, n=1}
            // map.put(ch, map.getOrDefault(ch, 0) + 1); // { =2, a=1, s=2, t=3, D=1, e=3, u=1, g=1, H=1, i=2, n=1}
        }

        return map;
    }

}
