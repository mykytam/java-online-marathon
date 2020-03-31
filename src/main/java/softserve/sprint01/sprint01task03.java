package softserve.sprint01;

/* Write a method that takes a year as input, and returns the century it is in.
The first century spans from the year 1 up to and including the year 100,
The second century spans from the year 101 up to and including the year 200, etc. */

public class sprint01task03 {
    public static void main( String[] args )
    {
        System.out.println(century(102));
    }

    public static int century(int year) {
        if (year <= 100) return 1;
        else if (year % 100 == 0) return year/100;
        else return (year/100 +1);
    }
}
