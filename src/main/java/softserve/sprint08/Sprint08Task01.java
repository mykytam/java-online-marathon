package softserve.sprint08;

// Please, implement a static method getCount that takes an array of integers as the first parameter.
// The second parameter - a functional interface that works with integers and defines a condition.
// The method should return the count of elements in the array that satisfy the condition defined by the second argument.

import java.util.function.Predicate;

class MyUtils {

    public static int getCount(int[] arr, Predicate<Integer> condition) {
        int counter = 0;
        for (int i : arr) {
            if (condition.test(i)) {
                counter++;
            }
        }
        return counter;
    }

}
