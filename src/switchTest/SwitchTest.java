package switchTest;

import java.time.temporal.ChronoUnit;

public class SwitchTest {
    public static void main(String[] args) {
        System.out.println(getDescription(null));
        printReserved("123456789010111213");
//        printReserved(new Integer(1234));
    }

    static String getDescription(ChronoUnit val) {
        return switch (val) {
            case ChronoUnit.SECONDS, ChronoUnit.MINUTES, ChronoUnit.HOURS -> "time";
            case ChronoUnit.DAYS, ChronoUnit.MONTHS, ChronoUnit.YEARS -> "date";
            case null, default -> "not supported";
        };

        // oder

//        return switch (val) {
//            case ChronoUnit.SECONDS, ChronoUnit.MINUTES, ChronoUnit.HOURS: yield "time";
//            case ChronoUnit.DAYS, ChronoUnit.MONTHS, ChronoUnit.YEARS: yield "date";
//            case null, default: yield "not supported";
//        };
    }

    static void printReserved(Object obj) {
        Object ref = switch (obj) {
            case int[] i -> i;
            case double[] d -> d;
            case Object[] o -> o;
            case null -> "llun";
            case String s when s.length() < 10 -> s;
            case String s when s.length() > 10 -> s.substring(s.length() - 7) + "...";
            default -> obj.toString();
        };

        System.out.println(ref);
    }
}
