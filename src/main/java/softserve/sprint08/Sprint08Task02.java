package softserve.sprint08;

// All array values that are greater than 2 should be multiplied by 0.8, and other values should be multiplied by 0.9.
// The method should return an array changed by the second parameter.

import java.util.Arrays;
import java.util.function.Consumer;

class App2 {
    static Consumer<double[]> cons = value -> {
        for (int i = 0; i < value.length; i++) {
            double v = value[i];
            if (v > 2) {
                value[i] *= 0.8;
            } else {
                value[i] *= 0.9;
            }
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> cons) {
        double[] kek = Arrays.copyOf(initialArray, initialArray.length);
        cons.accept(kek);
        return kek;
    }
}

