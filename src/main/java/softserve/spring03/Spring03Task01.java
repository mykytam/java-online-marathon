package softserve.spring03;

/*
Create a arrSort() method of the MyUtils class to sort a two-dimensional integer array by descending the elements of the first column.
In the case of equality of elements in the first column, the elements of the second column must be sorted in ascending order.
 */

import java.util.Arrays;

public class Spring03Task01 {
    public int[][] arrSort(int[][] arr) {

        if (Arrays.stream(arr).filter(ints -> ints.length != 0).map(ints -> ints[0]).distinct().count() != 1) {
            Arrays.sort(arr, (entry1, entry2) -> {
                if (entry1.length > 0 && entry2.length > 0) {
                    return Integer.compare(entry2[0], entry1[0]);
                } else {
                    return -1;
                }
            });
        } else {
            Arrays.sort(arr, (entry1, entry2) -> {
                if (entry1.length > 1 && entry2.length > 1) {
                    return Integer.compare(entry1[1], entry2[1]);
                } else {
                    return -1;
                }
            });
        }
        return arr;
    }
}
