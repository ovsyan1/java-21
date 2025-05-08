package streamCountMinMax;

import java.util.*;
import java.util.stream.Stream;

public class StreamCountMinMax {
    public static void main(String... args) {
        Locale[] locales = Locale.getAvailableLocales();

        for(Locale l : locales)
            System.out.println(l.getDisplayCountry());

        //A1
        Stream.of(locales)
                .max(Comparator.comparing(Locale::getDisplayCountry))
                .ifPresent(x -> System.out.println(x.getDisplayCountry()));

        System.out.println("******************");
        //A2
        long countOfDECountries = Stream.of(locales)
                .filter(x -> x.getLanguage().equals("de"))
                .count();
        System.out.println("countOfDECountries: " + countOfDECountries);

        System.out.println("******************");
        //A3
        String country = Stream.of(locales)
                .filter(x -> x.getDisplayCountry().toLowerCase().contains("t"))
                .min(Comparator.comparing(Locale::getDisplayLanguage))
                .map(locale -> "Country: " + locale.getDisplayCountry() + " Language: " + locale.getDisplayLanguage())
                .orElse("Country not found");

        System.out.println(country);
    }
}
