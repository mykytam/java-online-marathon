package softserve.sprint03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Create the strSort() method of the MyUtils class to sort a list of strings
first by length and alphabetically within the same length. The original list must be unchanged.
For example, for a given list [zz, abc, aa, aaa] you should get [aa, zz, aaa, abc].
 */

public class Spring03Task02 {
    public List<String> strSort(List<String> originList) {

        List<String> copy = new ArrayList<>(originList);
        Collections.sort(copy);

        // first way
        copy.sort((first, second) -> Integer.compare(first.length(), second.length()));
        return copy;

        // second way (IntellijIDEA's replacement)
        //copy.sort(Comparator.comparingInt(String::length));
        //return copy;

        // third way
        //Comparator<String> strLengthComp = (a, b) -> Integer.compare(a.length(), b.length());
        //Collections.sort(copy,  strLengthComp);

        // fourth way
        //Comparator<String> lengthComparator = new Comparator<String>() {
        //    public int compare(String s1, String s2) { return s1.length() - s2.length();}};
        //Collections.sort(copy,  lengthComparator);

        // fifth way
        //Comparator<String> strLengthComp = (a, b) -> Integer.compare(a.length(), b.length());
        //return originList.stream().sorted(strLengthComp).collect(Collectors.toList())

    }
}
