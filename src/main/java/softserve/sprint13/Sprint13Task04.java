package softserve.sprint13;

// Write a method to get the date n-years m-months and k-days after today using new DateTime API.
// return the obtained date in the format ISO_LOCAL_DATE.

import java.time.LocalDate;

public class Sprint13Task04 {
    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate localDate = LocalDate.now().plusYears(years).plusMonths(months).plusDays(days);
        return String.valueOf(localDate);
    }
}
