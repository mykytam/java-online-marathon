package softserve.sprint13;

// Write a method to get the name of last day of the given month in given year.
// Use GregorianCalendar class to solve this exercise.
// The name of day must corresponds next format: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday.
// If month isn't correct then name is "Wrong Month".

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Sprint13Task02 {
    public static String lastDayOfMonth(int month, int year) {

        if (month < 0 || month >= 12) {
            return "Wrong Month";
        }

        GregorianCalendar cal = new GregorianCalendar();
        cal.set(year, month, 1);
        int max = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

        GregorianCalendar calNew = new GregorianCalendar();
        calNew.set(year, month, max);

        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[calNew.get(Calendar.DAY_OF_WEEK) - 1];

    }
}
