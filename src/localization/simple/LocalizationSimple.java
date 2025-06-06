package localization.simple;

import java.util.Locale;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class LocalizationSimple {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static void main(String... unused) {
//        Locale.setDefault(Locale.UK);
        var dateNow = LocalDate.now();
        ResourceBundle bundle = ResourceBundle.getBundle("localization.translations.text");

        String greeting = bundle.getString("greeting");
        String todayIs = bundle.getString("todayIs");
        String itIs = bundle.getString("itIs");
        String dateFormat = bundle.getString("dateFormat");


        System.out.println(ANSI_PURPLE_BACKGROUND + ANSI_BLACK + greeting + " " + System.getProperty("user.name") + ANSI_RESET);

        ResourceBundle bundleConfig = ResourceBundle.getBundle("localization.simple.config");
        String defaultUserBirthday = System.getProperty("user.birthday");

        if (defaultUserBirthday == null) {
            String customUserBirthday = bundleConfig.getString("birthday-data");

            String month = customUserBirthday.substring(customUserBirthday.indexOf(".") + 1, customUserBirthday.lastIndexOf("."));
            String day = customUserBirthday.substring(0, customUserBirthday.indexOf("."));

            int currentMonth = dateNow.getMonthValue();
            int currentDay = dateNow.getDayOfMonth();


            if (Integer.parseInt(month) == currentMonth && Integer.parseInt(day) == currentDay) {
                System.out.println(bundle.getString("happyBirthday"));
            } else {
                // TODO: check why with future dates result is negative
//                try {
//                    System.out.println(bundle.getString("daysUntilYourBirthday") + ChronoUnit.DAYS.between(LocalDate.of(2025, Integer.parseInt(month), Integer.parseInt(day)), dateNow));
//                } catch (DateTimeException e) {
//                    System.out.println(e.getMessage());
//                }

            }
        } else {
            // TODO: add short logic for birthday from System.Properties
        }

        var currentDateFormat = DateTimeFormatter.ofPattern(dateFormat);
        // var currentDateFormat = DateTimeFormatter.ofPattern(dateFormat, Locale.getDefault());
        // var myDateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        var weekDayFormat = DateTimeFormatter.ofPattern("EEEE.");

        System.out.println(todayIs + " " + dateNow.format(currentDateFormat));
        System.out.println(itIs + " " + dateNow.format(weekDayFormat));
    }
}
