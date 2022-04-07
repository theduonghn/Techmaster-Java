public class Bai2114 {
    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            int numWords = countWords(sentences[i]);
            if (numWords > max) {
                max = numWords;
            }
        }
        return max;
    }

    public static int countWords(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                count++;
            }
        }
        return count + 1;
    }
}
