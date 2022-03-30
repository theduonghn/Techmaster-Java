import java.util.Arrays;

public class Bai066 {
    public static int[] plusOne(int[] digits) {
        int n = digits.length; // number of digits
        int[] newDigits = digits.clone();
        int plus = 1;
        for (int i = n - 1; i >= 0; i--) {
            newDigits[i] = newDigits[i] + plus;
            if (newDigits[i] >= 10) {
                plus = newDigits[i] / 10;
            } else {
                plus = 0;
            }
            newDigits[i] = newDigits[i] - 10 * plus;
        }
        if (plus == 0) {
            // Number of digits unchanged
            return newDigits;
        } else {
            // Number of digits increased by 1, create new array with n+1 elements to store
            // result
            int[] result = new int[n + 1];
            result[0] = 1;
            System.arraycopy(newDigits, 0, result, 1, n);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] digits1 = new int[] { 1, 2, 3 };
        System.out.println(Arrays.toString(plusOne(digits1)));
        int[] digits2 = new int[] { 9, 9, 9 };
        System.out.println(Arrays.toString(plusOne(digits2)));
        int[] digits3 = new int[] { 8, 0, 9 };
        System.out.println(Arrays.toString(plusOne(digits3)));
    }
}
