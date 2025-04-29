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
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }

}
