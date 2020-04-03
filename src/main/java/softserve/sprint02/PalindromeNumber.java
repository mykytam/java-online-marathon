package softserve.sprint02;

/* Determine whether an integer is a palindrome.
An integer is a palindrome when it reads the same backward as forward */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int num = x, reversed = 0;

        while(num != 0) {
            int digit = num % 10; // every digit
            reversed = reversed * 10 + digit; // reversed number
            num =  num/10; // making smaller to get new digit
        }
        if (reversed == x) {
            return true;
        } else {
            return false;
        }
    }
}
