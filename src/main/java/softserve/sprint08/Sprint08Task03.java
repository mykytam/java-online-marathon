package softserve.sprint08;

// greetingOperator should work with strings. It forms a new string as a result by the rule: "Hello " + parameter1 + " " + parameter2 + "!!!"

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

class App3 {
    static BinaryOperator<String> greetingOperator =
            (name, surname) -> "Hello " + name + " " + surname + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> greetingOperator) {
        List<String> greetings = new ArrayList<>();

        for (Person person : people) {
            greetings.add((String) greetingOperator.apply(person.name, person.surname));
        }
        return greetings;

    }
}


