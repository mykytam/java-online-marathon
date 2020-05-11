package softserve.sprint13;

// Write a method to check if a year is a leap year or not, using for this the LocalDate class.
// If a year is leap then method should return true, otherwise - false.

import java.time.LocalDate;

public class Sprint13Task03 {
    public static boolean isLeapYear(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        return date.isLeapYear();
    }
}
