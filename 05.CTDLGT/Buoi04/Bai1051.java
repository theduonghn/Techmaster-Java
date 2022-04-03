import java.util.Arrays;

public class Bai1051 {
    public static int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[] { 1, 1, 4, 2, 1, 3 })); // 3
        System.out.println(heightChecker(new int[] { 5, 1, 2, 3, 4 })); // 5
        System.out.println(heightChecker(new int[] { 1, 2, 3, 4, 5 })); // 0
    }
}