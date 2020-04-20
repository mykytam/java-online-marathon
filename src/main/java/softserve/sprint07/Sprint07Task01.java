package softserve.sprint07;

//Create public static inner class named PizzaBuilder inside Pizza class that correspond the class diagram
//Inside the cook method create and return an instance of Pizza class with your favorite ingredients.

class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() {
    }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }

    public static class PizzaBuilder {
        private Pizza pizza;

        private PizzaBuilder() {
            pizza = new Pizza();
        }

        ;

        public PizzaBuilder addCheese(String cheese) {
            pizza.cheese = cheese;
            return this;
        }

        ;

        public PizzaBuilder addMeat(String meat) {
            pizza.meat = meat;
            return this;
        }

        ;

        public PizzaBuilder addSeafood(String seafood) {
            pizza.seafood = seafood;
            return this;
        }

        ;

        public PizzaBuilder addVegetable(String vegetable) {
            pizza.vegetable = vegetable;
            return this;
        }

        ;

        public PizzaBuilder addMushroom(String mushroom) {
            pizza.mushroom = mushroom;
            return this;
        }

        ;

        public Pizza build() {
            return pizza;
        }

        ;
    }
}

class Oven {
    public static Pizza cook() {
        return Pizza.base().addCheese("parmezan")
                .addMeat("chicken")
                .addMushroom("opyata")
                .build();
    }
}