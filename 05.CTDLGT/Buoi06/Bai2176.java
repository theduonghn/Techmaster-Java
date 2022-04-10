public class Bai2176 {
    public static int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(new int[] { 3, 1, 2, 2, 2, 1, 3 }, 2)); // 4
        System.out.println(countPairs(new int[] { 1, 2, 3, 4 }, 1)); // 0
    }
}
