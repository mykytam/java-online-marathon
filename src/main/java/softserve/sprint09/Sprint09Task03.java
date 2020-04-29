package softserve.sprint09;

// Write a String pigLatinConverter(String text) method to convert input text into Pig latin

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sprint09Task03 {
    public String pigLatinConverter(String text) {

        String[] textArr = text.split(" ");
        Pattern firstVowelPattern = Pattern.compile("^([aeiouAEIOU])");

        for (int i = 0; i < textArr.length; i++) {
            Matcher matcher = firstVowelPattern.matcher(textArr[i]);

            if (matcher.find()) {
                textArr[i] = textArr[i] + "hay";
            } else {
                textArr[i] = textArr[i].replaceAll("^([^aeiouAEIOU]*)(.+)", "$2$1ay");
            }

            if (textArr[i].contains(".")) {
                textArr[i] = textArr[i].replace(".", "");
                textArr[i] = textArr[i] + ".";
            }

        }

        return String.join(" ", textArr);
    }
}