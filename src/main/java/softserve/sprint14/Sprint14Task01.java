package softserve.sprint14;

// Let the key of Map is project name and value contains list of participants.
// Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted stream of all participants without duplication.
// Please ignore null or empty strings, extra spaces and case sensitivity.
// Throw NullPointerException if map is null.

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class Sprint14Task01 {
    public class MyUtils {
        public Stream<String> nameList(Map<String, Stream<String>> map) {
            if (map.isEmpty()) {
                throw new NullPointerException();
            }

            return map.values()
                    .stream()
                    .flatMap(Function.identity())
                    .map(stringStream -> stringStream.toLowerCase().substring(0, 1).toUpperCase())
                    .filter(stringStream -> !stringStream.equals(""))
                    .filter(stringStream -> !stringStream.equals(" "))
                    .filter(stringStream -> stringStream != null)
                    .distinct()
                    .sorted();
        }
    }

}
