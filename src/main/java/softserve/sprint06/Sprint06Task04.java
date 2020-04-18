package softserve.sprint06;

// MyUtils class to return a List with instances of maximum area.

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();
}

class Circle extends Shape {
    private static final double pi = 3.14;
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * pi;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return height * width;
    }
}

class MyUtils04 {
    public List<Shape> maxAreas(List<Shape> shapes) {

        Double maxRect = shapes.stream()
                .filter(Objects::nonNull)
                .filter(shape -> shape instanceof Rectangle)
                .map(rect -> (Rectangle) rect)
                .mapToDouble(Rectangle::getArea)
                .max()
                .getAsDouble();

        List<Shape> rectList = shapes.stream()
                .filter(Objects::nonNull)
                .filter(shape -> shape instanceof Rectangle)
                .map(rect -> (Rectangle) rect)
                .filter(rect -> rect.getArea() == maxRect)
                .distinct()
                .collect(Collectors.toList());

        Double maxCircle = shapes.stream()
                .filter(Objects::nonNull)
                .filter(shape -> shape instanceof Circle)
                .map(circ -> (Circle) circ)
                .mapToDouble(Circle::getArea)
                .max()
                .getAsDouble();

        List<Shape> circleList = shapes.stream()
                .filter(Objects::nonNull)
                .filter(shape -> shape instanceof Circle)
                .map(circl -> (Circle) circl)
                .filter(circl -> circl.getArea() == maxCircle)
                .distinct()
                .collect(Collectors.toList());


        rectList.addAll(circleList);
        return rectList;
    }
}
