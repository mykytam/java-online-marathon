package softserve.sprint14;

// Create a int countNumbers(IntStream intNum, Stream<String> strNum) method of the MyUtils class to count of numbers that is divisible by 3 or contains the digit 3.
// The parameters of the method are two Streams with integers and Strings with one number.

//For example, for a given
//[[3, 2, 1, 13, 21, 15], ["9", "4", "23", "0", "32", "5"]]
//you should get 7

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MyUtils1404 {
    public long countNumbers(IntStream intNum, Stream<String> strNum) {

        long countNums = intNum
                .filter(Objects::nonNull)
                .filter(num -> num != 0)
                .filter(num -> num % 10 == 3 || num % 100 == 3 || num % 3 == 0 || num / 10 == 3 || num % 10 == -3 || num % 100 == -3 || num / 10 == -3)
                .count();

        long countString = strNum
                .filter(Objects::nonNull)
                .filter(num -> !num.isBlank())
                .map(Integer::valueOf)
                .filter(num -> num != 0)
                .filter(num -> num % 10 == 3 || num % 100 == 3 || num % 3 == 0 || num / 10 == 3 || num % 10 == -3 || num / 10 == -3 || num % 100 == -3)
                .count();

        return countNums + countString;
    }
}