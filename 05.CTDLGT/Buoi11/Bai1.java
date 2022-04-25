import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bai1 {
    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (set.contains(remaining)) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] == remaining) {
                        return new int[] { i, j };
                    }
                }
            } else {
                set.add(nums[i]);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9))); // [0,1]
        System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6))); // [1,2]
        System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6))); // [0,1]
    }
}
