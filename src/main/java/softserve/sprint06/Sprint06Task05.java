package softserve.sprint06;

// Create a averageRating() method of the MyUtils class to return a Map with coffee name as key and coffee average rating as value.

import java.util.*;
import java.util.stream.Collectors;

interface DrinkReceipt {
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink(); // return drink component
}

interface Rating {
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> prepareCoffee = new HashMap<>();
        prepareCoffee.put("Water", 100);
        prepareCoffee.put("Arabica", 20);
        return prepareCoffee;
    }
}

class Espresso extends Caffee { // use 50g Water
    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> prepareEspresso = new HashMap<>();
        prepareEspresso.put("Water", 50);
        prepareEspresso.put("Arabica", 20);
        return super.makeDrink();
    }
}

class Cappuccino extends Caffee { // + 50g Milk
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> prepareCappuccino = new HashMap<>();
        prepareCappuccino.put("Water", 100);
        prepareCappuccino.put("Arabica", 20);
        prepareCappuccino.put("Milk", 50);
        return super.makeDrink();
    }
}

class MyUtils05 {
    public Map<String, Double> averageRating(List<Caffee> coffees) {

        Map<String, Double> test = new LinkedHashMap<>();

        List<String> coffeesName = coffees.stream()
                .filter(Objects::nonNull)
                .map(Caffee::getName)
                .distinct()
                .collect(Collectors.toList());

        double coffeesRating = coffees.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Caffee::getRating)
                .average()
                .getAsDouble();

        double espressoRating = coffees.stream()
                .filter(Objects::nonNull)
                .filter(espresso -> espresso instanceof Espresso)
                .map(coffee -> (Espresso) coffee)
                .mapToDouble(Espresso::getRating)
                .average()
                .getAsDouble();

        double cappuccinoRating = coffees.stream()
                .filter(Objects::nonNull)
                .filter(cappuccino -> cappuccino instanceof Cappuccino)
                .map(coffee -> (Cappuccino) coffee)
                .mapToDouble(Cappuccino::getRating)
                .average()
                .getAsDouble();


        test.put(coffeesName.get(0), espressoRating);
        test.put(coffeesName.get(1), cappuccinoRating);
        test.put(coffeesName.get(2), coffeesRating);


        return test;
    }
}