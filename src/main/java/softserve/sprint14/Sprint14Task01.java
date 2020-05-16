package softserve.sprint14;

// Let the key of Map is project name and value contains list of participants.
// Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted stream of all participants without duplication.
// Please ignore null or empty strings, extra spaces and case sensitivity.
// Throw NullPointerException if map is null.

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

class MyUtils1401 {
    public Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map.isEmpty()) {
            throw new NullPointerException();
        }

        return map.values()
                .stream()
                .flatMap(Function.identity())
                .filter(Objects::nonNull)
                .filter(num -> !num.isBlank())
                .map(spaces -> spaces.replaceAll("\\s*", ""))
                .map(String::toLowerCase)
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .distinct()
                .sorted();
    }
}