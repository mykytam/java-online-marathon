package softserve.sprint08;

// goShopping defines if Person will do shopping based on product name and discount that come as parameters.
// You should define the next default behavior for goShopping: return true if product name = "product1" and discount > 10, otherwise return false.
// Define the type for goShopping field and name it DecisionMethod and define a method decide in it.
// sale method informs users about a discount product and a percentage of discount by using their goShopping values (which are stored in clients field).
// The method should return the count of users that will go shopping.

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface DecisionMethod {
    boolean decide(String product, int percent);
}

class Person04 {
    public DecisionMethod goShopping = (name, discount) -> {
        if (discount > 10 && name.equals("product1")) {
            return true;
        } else {
            return false;
        }
    };
    String name;

    Person04(String name) {
        this.name = name;
    }
}

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        return (int) clients.stream().filter(decisionMethod -> decisionMethod.decide(product, percent)).count();
    }
}