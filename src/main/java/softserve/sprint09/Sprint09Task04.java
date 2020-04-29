package softserve.sprint09;

// Write a String differentWords(String originalText, String modifyText) method to compare originalText and modifyText.
// The differentWords() method return the modified text with uppercase of additional words.

public class Sprint09Task04 {
    public String differentWords(String originalText, String modifyText) {

        if (originalText == null || originalText.isEmpty()) {
            return modifyText.toUpperCase();
        }

        if (modifyText == null || modifyText.isEmpty()) {
            return "";
        }

        String org = originalText.replaceAll("( )+", " ").trim();
        String mod = modifyText.replaceAll("( )+", " ").trim();

        String[] orgArr = org.split(" ");
        String[] modArr = mod.split(" ");


        for (int i = 0, j = 0; i < orgArr.length; i++, j++) {


            while (!modArr[j].equals(orgArr[i])) {
                modArr[j] = modArr[j].toUpperCase();
                j++;
            }
        }

        if (!modArr[modArr.length - 1].equals(orgArr[orgArr.length - 1])) {
            modArr[modArr.length - 1] = modArr[modArr.length - 1].toUpperCase();
        }

        return String.join(" ", modArr);
    }
}
