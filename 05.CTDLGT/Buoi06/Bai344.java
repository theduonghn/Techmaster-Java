public class Bai344 {
    public static void reverseString(char[] s) {
        f(s, 0, s.length - 1);
    }

    // f(a, i, j) => doi cho a[i] & a[j]
    public static void f(char[] s, int i, int j) {
        if (i >= j) {
            return;
        }
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
        f(s, i + 1, j - 1);
    }

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s);
        System.out.println(s);
    }
}