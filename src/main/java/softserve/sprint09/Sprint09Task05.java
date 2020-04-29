package softserve.sprint09;

// Write a String reformatLines(String text) method of the MyUtils class to replacing all spaces with one and reformat lines of input text.
// Length of every lines should not exceed 60 characters.

public class Sprint09Task05 {
    public String reformatLines(String text) {

        String noSpace = text.replaceAll("( )+", " ").replaceAll("\n", "").trim();
        String replaced = noSpace.replaceAll(".{60}", "$0\n");
        return replaced;


//        String noTabs = text.replaceAll("( )+", " ").replaceAll("\n", "").trim();
//        String[] textArr = noTabs.split(" ");
//
//        StringBuilder makingString = new StringBuilder();
//        int forIf = 60;
//        for (String toAppend : textArr) {
//
//            if (makingString.append(toAppend).append(" ").length() > forIf) {
//                int firstIndex = makingString.lastIndexOf(toAppend) - 1;
//                int lastIndex = makingString.length() - 1;
//                makingString.delete(firstIndex, lastIndex);
//                int left = forIf - makingString.length();
//                makingString.append("\n");
//                makingString.append(toAppend).append(" ");
//                forIf = forIf + 60 - left;
//
//            }
//        }
//
//        return makingString.toString();
    }
}
