import java.util.HashSet;
import java.util.Set;

public class Bai217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num) == false) { // set already contains element equals to num
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 2 })); // true
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 })); // false
    }
}
