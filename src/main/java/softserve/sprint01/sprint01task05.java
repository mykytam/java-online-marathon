package softserve.sprint01;

/* Write a method to check if a year is a leap year or not, using only Relational and Logical operators.
If a year is leap then method should return true, otherwise - false. */

public class sprint01task05 {
    public static void main( String[] args )
    {
        System.out.println(isLeapYear(2000));
    }

    public static boolean isLeapYear(int year) {
        // == != > < >= <= && || !
        boolean ifLeap = false;

        if((year % 4) == 0)
        {
            if( (year % 100) == 0)
            {
                if ( (year % 400) == 0)
                    ifLeap = true;
                else
                    ifLeap = false;
            }
            else
                ifLeap = true;
        }
        else {
            ifLeap = false;
        }
        return ifLeap;
    }
}
