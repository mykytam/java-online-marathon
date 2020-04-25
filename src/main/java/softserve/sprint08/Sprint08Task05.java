package softserve.sprint08;

// Please, implement a static method getPredicateFromSet in MyUtils class.
// getPredicateFromSet should take a Set of predicates working with integers as a parameter
// and return a predicate with the functionality of all predicates in the set invoked and connected by logical AND.

import java.util.Set;
import java.util.function.Predicate;

class MyUtils05 {
    public static Predicate getPredicateFromSet(Set<Predicate<Integer>> predicateSet) {
        return predicateSet.stream().reduce(x -> true, Predicate::and);
    }
}
