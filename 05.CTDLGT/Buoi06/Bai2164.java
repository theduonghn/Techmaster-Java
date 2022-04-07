import java.util.Arrays;

public class Bai2164 {
    public static int[] sortEvenOdd(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean odd = isOdd(nums[i]);
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (odd) {
                    if (!isOdd(nums[j])) {
                        continue;
                    }
                    if (nums[j] > nums[i]) {
                        int t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                    }
                } else {
                    if (isOdd(nums[j])) {
                        continue;
                    }
                    if (nums[j] < nums[j]) {
                        int t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                    }
                }
            }
        }
        return nums;
    }

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortEvenOdd(new int[] { 4, 1, 2, 3 })));
    }
}
