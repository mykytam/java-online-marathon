package softserve.sprint01;

// Write a method to compute the sum of the digits in a three-digits positive integer number.

public class sprint01task04 {
    public static void main( String[] args )
    {
        System.out.println(sumOfDigits(254));
    }
    public static int sumOfDigits(int number) {
        int hundreds = (number / 100) % 10; // first
        int tens = (number / 10) % 10; // second
        int units = (number / 1) % 10; // third
        int result = hundreds + tens + units;
        return result;
    }
}
