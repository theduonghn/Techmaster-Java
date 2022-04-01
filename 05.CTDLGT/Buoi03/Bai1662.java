public class Bai1662 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String string1 = join(word1);
        String string2 = join(word2);
        return string1.equals(string2);
    }

    public static String join(String[] arr) {
        String result = "";
        for (String s : arr) {
            result = result.concat(s);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[] { "a", "cb" }, new String[] { "ab", "c" })); // false
        System.out.println(arrayStringsAreEqual(new String[] { "abc", "d", "defg" }, new String[] { "abcddefg" })); // true
    }
}