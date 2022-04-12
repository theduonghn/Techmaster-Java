public class Bai1550 {
    public static boolean threeConsecutiveOdds(int[] arr) {
        int countOdd = 0;
        for (int e : arr) {
            if (e % 2 != 0) {
                countOdd++;
            } else {
                countOdd = 0;
            }
            if (countOdd >= 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[] { 2, 6, 4, 1 })); // false
        System.out.println(threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 })); // true
    }
}
