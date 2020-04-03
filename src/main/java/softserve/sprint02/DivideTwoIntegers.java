package softserve.sprint02;

/* Given two integers dividend and divisor, divide two integers
without using multiplication, division and mod operator.
Return the quotient after dividing dividend by divisor. */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // division is like subtraction, but several times
        // need to subtract the divider until come to divisor
        // and then count how many iterations it took
        int count = 0;
        
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            if (dividend > 0) {
                count++;
            }
        }
        return count;
    }
}
