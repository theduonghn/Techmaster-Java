import java.util.HashSet;
import java.util.Set;

public class Bai268 {
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 })); // 8
    }
}
