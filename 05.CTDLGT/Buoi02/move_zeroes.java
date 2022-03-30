import java.util.Arrays;

public class move_zeroes {
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length - 1 -i; j++) {
                if (nums[j] == 0) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input1 = new int[] { 0, 0, 1 };
        moveZeroes(input1);
        System.out.println(Arrays.toString(input1));
    }
}