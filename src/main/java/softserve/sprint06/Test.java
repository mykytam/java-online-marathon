package softserve.sprint06;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // First task
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ivan"));
        people.add(new Student("Petro", "University", 3));
        people.add(new Worker("Andriy", "Developer", 12));
        people.add(new Student("Stepan", "College", 4));
        people.add(new Worker("Ira", "Manager", 8));
        people.add(new Student("Ihor", "University", 4));

        MyUtils1 test1 = new MyUtils1();
        test1.maxDuration(people);

        // Second task
        List<Employee> workers = new ArrayList<>();
        workers.add(new Employee("Ivan", 10, BigDecimal.valueOf(3000.00)));
        workers.add(new Manager("Petro", 9, BigDecimal.valueOf(3000.00), 1.5));
        workers.add(new Employee("Stepan", 8, BigDecimal.valueOf(4000.00)));
        workers.add(new Employee("Andriy", 7, BigDecimal.valueOf(3500.00)));
        workers.add(new Employee("Ihor", 5, BigDecimal.valueOf(4500.00)));
        workers.add(new Manager("Vasyl", 8, BigDecimal.valueOf(2000.00), 2.0));

        MyUtils02 test2 = new MyUtils02();
        test2.largestEmployees(workers);

        // Third task
        List<Figure> figures = new ArrayList<>();
        figures.add(new Square(4.00));
        figures.add(new Square(5.00));
        figures.add(new Rectang(2.00, 3.00));

        MyUtils03 test3 = new MyUtils03();
        test3.sumPerimeter(figures);

        // Fourth task
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("Circle", 2.00));
        shapes.add(new Rectangle("Rectangle", 3.00, 2.00));
        shapes.add(new Circle("Circle", 1.00));
        shapes.add(new Rectangle("Rectangle", 2.00, 3.00));
        shapes.add(new Circle("Circle", 0.50));
        shapes.add(new Rectangle("Rectangle", 2.00, 1.00));

        MyUtils04 test4 = new MyUtils04();
        test4.maxAreas(shapes);

        // Fifth task
        List<Caffee> coffees = new ArrayList<>();
        coffees.add(new Espresso("Espresso", 8));
        coffees.add(new Cappuccino("Cappuccino", 10));
        coffees.add(new Espresso("Espresso", 10));
        coffees.add(new Cappuccino("Cappuccino", 6));
        coffees.add(new Caffee("Caffee", 6));

        MyUtils05 test5 = new MyUtils05();
        test5.averageRating(coffees);
    }
}
