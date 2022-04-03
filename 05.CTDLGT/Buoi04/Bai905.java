import java.util.Arrays;

public class Bai905 {
    public static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0;
        int j = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[i] = num;
                i++;
            } else {
                result[j] = num;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[] { 3, 1, 2, 4 })));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] { 3, 1, 2, 5, 98, 7 })));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] { 10, 3, 2, 1, 7, 4 })));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] { 5, 5, 5, 5, 5 })));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] { 2, 2, 2, 2 })));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] { 0 })));
    }
}