package softserve.sprint10;

// Create classes with name PersonComparator, EmployeeComparator, DeveloperComparator that implenent the Comparator<Type> generic interface.
// In the Utility class create public static method named sortPeople(...) that takes an array of Person type and derivative from it types,
// and comparator as input, and returns the value of void type.
//Also, as second argument the method sortPeople(...) can takes generic comparator for elements of Object type.
//The sortPeople(...) method should sorted records by ascending. At first by name, then by age, then by salary, and then by Level (JUNIOR < MIDDLE < SENIOR)

import java.util.Arrays;
import java.util.Comparator;


enum Level {
    JUNIOR, MIDDLE, SENIOR
}

class Utility {
    public static <T extends Person> void sortPeople(T[] personArray, Comparator<? super T> comparator) {
        Arrays.sort(personArray, comparator);
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {

        int nameCompare = o1.getName().compareTo(o2.getName());
        int ageCompare = o1.getAge() - o2.getAge();

        if (nameCompare == 0) {
            return ageCompare;
        }
        return nameCompare;
    }
}

class EmployeeComparator implements Comparator<Employee> {
    static final PersonComparator personComparator = new PersonComparator();

    @Override
    public int compare(Employee o1, Employee o2) {
        if (personComparator.compare(o1, o2) != 0) {
            return personComparator.compare(o1, o2);
        }
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}

class DeveloperComparator implements Comparator<Developer> {
    static final EmployeeComparator employeeComparator = new EmployeeComparator();

    @Override
    public int compare(Developer o1, Developer o2) {
        if (employeeComparator.compare(o1, o2) != 0) {
            return employeeComparator.compare(o1, o2);
        }
        return o1.getLevel().toString().compareTo(o2.getLevel().toString());
    }
}

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Employee extends Person {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return super.toString() + ",Salary: " + salary;
    }
}

class Developer extends Employee {
    private Level level;

    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public String toString() {
        return super.toString() + ", Level: " + level.name();
    }
}