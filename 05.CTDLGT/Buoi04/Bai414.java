import java.util.Set;
import java.util.TreeSet;

public class Bai414 {
    public static int thirdMax(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int size = set.size();
        Integer[] arr = new Integer[size];
        arr = set.toArray(arr);

        if (size < 3) {
            return arr[size - 1];
        } else {
            return arr[size - 3];
        }
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[] { 3, 2, 1 })); // 1
        System.out.println(thirdMax(new int[] { 1, 2 })); // 2
        System.out.println(thirdMax(new int[] { 2, 2, 3, 1 })); // 1
        System.out.println(thirdMax(new int[] { 5, 2, 4, 1, 3, 6, 0 })); // 4
    }
}