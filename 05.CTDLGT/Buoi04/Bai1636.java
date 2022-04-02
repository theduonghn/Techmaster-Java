import java.util.Arrays;
import java.util.Comparator;

public class Bai1636 {
    public static int[] frequencySort(int[] nums) {
        Arrays.sort(nums, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                int frequencyO1 = frequency(o1, nums);
                int frequencyO2 = frequency(o2, nums);
            }
        });
        return null;
    }

    public static int frequency(int num, int[] nums) {
        int count = 0;
        for (int e : nums) {
            if (e == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[] { 1, 1, 2, 2, 2, 3 })));
    }
}