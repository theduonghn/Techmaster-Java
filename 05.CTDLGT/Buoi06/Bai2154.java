public class Bai2154 {
    public static int findFinalValue(int[] nums, int original) {
        while (true) {
            if (search(nums, original) == -1) {
                return original;
            } else {
                original *= 2;
            }
        }
    }

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[] { 5, 3, 6, 1, 12 }, 3)); // 24
        System.out.println(findFinalValue(new int[] { 2, 7, 9 }, 4)); // 4
    }
}
