package softserve.sprint02;

// Given a 32-bit signed integer, reverse digits of an integer.

public class ReverseInteger {
    public int reverse(int x) {
        int num = x, reversed = 0;

        while(num != 0) {
            int digit = num % 10; // every digit
            reversed = reversed * 10 + digit; // reversed number
            num =  num/10; // making smaller to get new digit
        }
        return reversed;
    }
}
