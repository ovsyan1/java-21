package mapSimple;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import java.time.Period;
import java.util.Set;

public class MapSimple {
    public static void main(String[] args) {
        Map<String, LocalDate> map = new HashMap<>();

        map.put("heute", LocalDate.now());
        map.put("gestern", LocalDate.now().minus(Period.ofDays(1)));
        map.put("morgen", LocalDate.now().plus(Period.ofDays(1)));

        map.forEach((str, time) -> System.out.println(str + " " + time));

        Set<Map.Entry<String, LocalDate>> set = map.entrySet();

        System.out.println(set);
    }
}
