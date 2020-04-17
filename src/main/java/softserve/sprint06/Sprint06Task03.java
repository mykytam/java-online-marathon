package softserve.sprint06;

// Create a double sumPerimeter(List<?> firures) method of the MyUtils class to return a sum perimeters of all figures.

import java.util.List;
import java.util.Objects;

abstract class Figure {
    double height;
    double width;

    abstract double getPerimeter();
}

class Rectang extends Figure {

    public Rectang(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return width * 2 + height * 2;
    }

}

class Square extends Figure {

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return width * 4;
    }
}

class MyUtils03 {
    public double sumPerimeter(List<? extends Figure> figures) {
        return figures.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Figure::getPerimeter)
                .sum();
    }
}
