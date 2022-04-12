import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai500 {
    public static String[] findWords(String[] words) {
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lowercaseWord = word.toLowerCase();
            boolean inFirstRow = true;
            boolean inSecondRow = true;
            boolean inThirdRow = true;
            for (int i = 0; i < lowercaseWord.length(); i++) {
                String c = lowercaseWord.substring(i, i + 1);
                if (!inFirstRow && !inSecondRow && !inThirdRow) {
                    break;
                }
                if (inFirstRow) {
                    if (!firstRow.contains(c)) {
                        inFirstRow = false;
                    }
                }
                if (inSecondRow) {
                    if (!secondRow.contains(c)) {
                        inSecondRow = false;
                    }
                }
                if (inThirdRow) {
                    if (!thirdRow.contains(c)) {
                        inThirdRow = false;
                    }
                }
            }
            if (inFirstRow || inSecondRow || inThirdRow) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[] {
                "Hello", "Alaska", "Dad", "Peace"
        })));
        System.out.println(Arrays.toString(findWords(new String[] {
                "omk"
        })));
        System.out.println(Arrays.toString(findWords(new String[] {
                "adsdf", "sfd"
        })));
    }
}
