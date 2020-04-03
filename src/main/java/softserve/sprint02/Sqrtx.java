package softserve.sprint02;

/* Implement int sqrt(int x).
Compute and return the square root of x,
where x is guaranteed to be a non-negative integer. */

public class Sqrtx {
    public int mySqrt(int x) {
        int i = 1, result = 1;
        while (result <= x) {
            i++; // degree increase
            result = i * i;
        }
        return i - 1; // decrease, 'cause result now is greater than x
    }
}
