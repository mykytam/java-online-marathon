package softserve.sprint10;

//In the class ArrayUtil write static method named "averageValue(...)" that takes an object of Array type as input, and returns the average value its elements.
//The given method should returns value of double type and take any array, whose elements extends Number type.

public class Sprint10Task04 {
    public static Number addNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        } else {
            return a.intValue() + b.intValue();
        }
    }

    static class ArrayUtil {
        public static <N extends Number> double averageValue(Array<N> originalArray) {
            Number sum = 0;

            for (int i = 0; i < originalArray.length(); i++) {
                sum = addNumbers(sum, originalArray.get(i));
            }

            return sum.doubleValue() / originalArray.length();
        }
    }
}

class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}

