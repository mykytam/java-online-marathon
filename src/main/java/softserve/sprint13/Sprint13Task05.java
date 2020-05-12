package softserve.sprint13;

// Write a method to read from a file a character-oriented data and return these data as String object.

import java.io.FileReader;
import java.io.IOException;

public class Sprint13Task05 {
    public static String readFile(String filename) {

        StringBuilder sb = new StringBuilder();

        try (FileReader fileReader = new FileReader(filename)) {

            int data = fileReader.read();

            while (data != -1) {
                sb.append((char) data);
                data = fileReader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(sb);
    }
}
