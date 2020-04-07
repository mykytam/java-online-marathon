package softserve.spring03;

import java.util.*;

/*
Create a createNotebook() method of the MyUtils class to create a new map with name as key and phone list as value.
The method receives a map  with phone as key and name as value.
For example, for a given map {0967654321=Petro, 0677654321=Petro, 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}
you should get {Ivan=[0501234567, 0631234567], Petro=[0967654321, 0677654321], Stepan=[0970011223]}.
 */

public class Spring03Task04 {
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {

        Map<String, List<String>> newPhones = new HashMap<>();

        for (String name : phones.values()) {
            List<String> phoneNumbers = new ArrayList<>();
            for (var entry : phones.entrySet()) {
                if (Objects.equals(entry.getValue(), name)) {
                    phoneNumbers.add(entry.getKey());
                }
            }
            newPhones.put(name, phoneNumbers);
        }
        return newPhones;
    }
}