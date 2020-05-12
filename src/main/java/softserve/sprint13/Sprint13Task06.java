package softserve.sprint13;

// Create the method writeFile(String filename, String text) that write the text to file as sequence of bytes in binary format.
// For example, the text fragment should be represented in the file as a sequence of 7-bit bytes without spaces between them.
// If less than 7 bits are required to represent the character then add to binary sequence leading zeros '0'.

import java.io.FileWriter;
import java.io.IOException;

public class Sprint13Task06 {
    public static void writeFile(String filename, String text) {

        StringBuilder binary = new StringBuilder();

        try (FileWriter writer = new FileWriter(filename)) {
            byte[] byteArray = text.getBytes();

            for (byte b : byteArray) {
                int val = b;
                for (int i = 0; i < 8; i++) {
                    binary.append((val & 128) == 0 ? 0 : 1);
                    val <<= 1;
                }
            }

            int first = 0;
            int last = 1;
            for (int i = 0; i < binary.length(); i++) {
                if (last < binary.length()) {
                    binary.replace(first, last, "");
                    first += 7;
                    last += 7;
                }
            }

            writer.write(binary.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
