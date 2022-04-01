public class Bai1221 {
    public static int balancedStringSplit(String s) {
        int count = 0;
        int countL = 0;
        int countR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                countL++;
            } else {
                countR++;
            }
            if (countL == countR) {
                count++;
                countL = 0;
                countR = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL")); // 4
        System.out.println(balancedStringSplit("RLLLLRRRLR")); // 3
        System.out.println(balancedStringSplit("LLLLRRRR")); // 1
    }
}