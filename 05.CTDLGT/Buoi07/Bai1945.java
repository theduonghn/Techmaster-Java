public class Bai1945 {
    public static int getLucky(String s, int k) {
        String digits = "";
        for (char c : s.toCharArray()) {
            int digit = c - 'a' + 1;
            digits += digit;
        }

        for (int i = 0; i < k; i++) {
            digits = calcSumDigits(digits);
        }
        return Integer.parseInt(digits);
    }

    public static String calcSumDigits(String digits) {
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum += Integer.parseInt(digits.substring(i, i + 1));
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1)); // 36
        System.out.println(getLucky("leetcode", 2)); // 6
        System.out.println(getLucky("zbax", 2)); // 8
        System.out.println(getLucky("fleyctuuajsr", 5)); // 8
    }
}
