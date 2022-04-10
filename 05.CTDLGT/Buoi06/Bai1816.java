public class Bai1816 {
    public static String truncateSentence(String s, int k) {
        String result = "";
        String[] words = s.split(" ");
        for (int i = 0; i < k; i++) {
            result += words[i] + " ";
        }
        return result.strip();
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4)); // "Hello how are you"
        System.out.println(truncateSentence("What is the solution to this problem", 4)); // "What is the solution"
        System.out.println(truncateSentence("chopper is not a tanuki", 5)); // "chopper is not a tanuki"
    }
}
