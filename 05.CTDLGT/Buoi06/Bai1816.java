public class Bai1816 {
    public String truncateSentence(String s, int k) {
        String result = "";
        String[] words = s.split(" ");
        for (int i = 0; i < k; i++) {
            result += words[i] + " ";
        }
        return result.strip();
    }
}
