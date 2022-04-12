public class Bai520 {
    public static boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        } else if (word.equals(word.toLowerCase())) {
            return true;
        } else if (word.substring(0, 1).equals(word.substring(0, 1).toLowerCase())) {
            return false;
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals(word.substring(i, i + 1).toUpperCase())) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        // System.out.println(detectCapitalUse("USA"));
        // System.out.println(detectCapitalUse("FlaG"));
        // System.out.println(detectCapitalUse("g"));
        System.out.println(detectCapitalUse("Leetcode"));
    }
}
