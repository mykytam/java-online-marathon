package softserve.sprint13;

// Create the method readFile(String filename) that read from file a sequence of bytes in binary format from previous task and return ridable string.

import java.io.FileReader;
import java.io.IOException;

public class Sprint13Task07 {
    public static String readFile(String filename) {

        StringBuilder builder = new StringBuilder();

        try (FileReader reader = new FileReader(filename)) {
            int singleCharInt;
            char singleChar;

            while ((singleCharInt = reader.read()) != -1) {
                singleChar = (char) singleCharInt;
                builder.append(singleChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return java.util.Arrays.stream(builder.toString().split("(?<=\\G.{7})")) /* regex to split the bits array by 7*/
                .parallel()
                .map(eightBits -> (char) Integer.parseInt(eightBits, 2))
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
                ).toString();
    }
}
