package localization.simple;

import java.time.format.FormatStyle;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class LocalizationSimple {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static void main(String... unused) {
        // Locale.setDefault(Locale.UK);
        ResourceBundle bundle = ResourceBundle.getBundle("localization.translations.text");

        String greeting = bundle.getString("greeting");
        String todayIs = bundle.getString("todayIs");
        String itIs = bundle.getString("itIs");
        String dateFormat = bundle.getString("dateFormat");


        System.out.println(ANSI_PURPLE_BACKGROUND + ANSI_BLACK + greeting + " " + System.getProperty("user.name") + ANSI_RESET);

        var currentDate = LocalDate.now();

        var currentDateFormat = DateTimeFormatter.ofPattern(dateFormat);
        // var currentDateFormat = DateTimeFormatter.ofPattern(dateFormat, Locale.getDefault());
        // var myDateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        var weekDayFormat = DateTimeFormatter.ofPattern("EEEE.");

        System.out.println(todayIs + " " + currentDate.format(currentDateFormat));
        System.out.println(itIs + " " + currentDate.format(weekDayFormat));
    }
}
