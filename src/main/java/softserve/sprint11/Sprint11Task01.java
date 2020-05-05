package softserve.sprint11;

// Create a method for calculating an area of a rectangle
//int squareRectangle(int a, int b), which should throw an IllegalArgumentException if at least one of its arguments is negative.
//Create trySquareRectangle method which takes two parameters and calls squareRectangle to evaluate an area of a rectangle. Catch exceptions that can be generated.
//trySquareRectangle shouldn't generate any exceptions. In case when one or two parameters are negative the method should return 0;

class Operation {
    public static int squareRectangle(int a, int b) throws IllegalArgumentException {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Negative number");
        } else {
            return a * b;
        }
    }

    public static int trySquareRectangle(int a, int b) {
        try {
            return squareRectangle(a, b);
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
}