import java.util.Arrays;

public class Bai1929 {
    public static int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] result = new int[length * 2];
        for (int i = 0; i < length; i++) {
            result[i] = result[i + length] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[] { 1, 2, 1 }))); // [1,2,1,1,2,1]
        System.out.println(Arrays.toString(getConcatenation(new int[] { 1, 3, 2, 1 }))); // [1,3,2,1,1,3,2,1]
    }
}
