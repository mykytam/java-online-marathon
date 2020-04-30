package softserve.sprint10;

// Using Wrapper generic class from task #1, modify it so that it can only wrap objects that implement the Shape interface (Square, Circle, etc.).

import java.awt.*;

public class Sprint10Task03 {
    public class Wrapper<T extends Shape> {
        private T value;

        public Wrapper(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
