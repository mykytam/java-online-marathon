package softserve.sprint14;

// Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) method of the MyUtils class to build a Map of all phone numbers.
// The key of Map is code of network and value contains sorted list of phones.
// Remove all spaces, brackets and dashes from phone numbers.

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyUtils {
    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        return list
                .stream()
                .flatMap(Function.identity())
                .filter(Objects::nonNull)
                .filter(num -> !num.isBlank())
                .map(number -> number.replaceAll("-|\\(|\\)| +", ""))
                .distinct()
                .collect(Collectors.groupingBy(num -> {
                    if (num.length() < 10) {
                        if (num.length() < 7) {
                            return "err";
                        }
                        return "loc";
                    }
                    return num.substring(0, 3);
                }, new StringToStreamCollector()));
    }
}

class StringToStreamCollector implements Collector<String, ArrayList<String>, Stream<String>> {

    @Override
    public Supplier<ArrayList<String>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<String>, String> accumulator() {
        return (strings, s) -> {
            if (s.length() == 10) {
                strings.add(s.substring(3));
            } else {
                strings.add(s);
            }
        };
    }

    @Override
    public BinaryOperator<ArrayList<String>> combiner() {
        return (left, right) -> {
            if (left.size() < right.size()) {
                right.addAll(left);
                return right;
            } else {
                left.addAll(right);
                return left;
            }
        };
    }

    @Override
    public Function<ArrayList<String>, Stream<String>> finisher() {
        return strings -> strings.stream().sorted();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}