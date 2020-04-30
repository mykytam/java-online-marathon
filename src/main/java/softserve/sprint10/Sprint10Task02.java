package softserve.sprint10;

// In the class ArrayUtil write a public static generic method named "setAndReturn(...)" to modify and return the element in an array from the given position.

public class Sprint10Task02 {
    static class ArrayUtil {
        public static <T> T setAndReturn(T[] array, T element, int index) {
            array[index] = element;
            return array[index];
        }
    }
}
