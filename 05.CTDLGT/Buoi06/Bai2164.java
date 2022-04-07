import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bai2164 {
    public static int[] sortEvenOdd(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }

        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = even.get(i / 2);
            } else {
                result[i] = odd.get(i / 2);
            }
        }

        return result;
    }

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortEvenOdd(new int[] { 4, 1, 2, 3 })));
        System.out.println(Arrays.toString(
                sortEvenOdd(new int[] { 36, 45, 32, 31, 15, 41, 9, 46, 36, 6, 15, 16, 33, 26, 27, 31, 44, 34 })));
    }
}
