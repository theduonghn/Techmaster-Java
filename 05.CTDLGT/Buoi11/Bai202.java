import java.util.HashSet;
import java.util.Set;

public class Bai202 {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.add(n) == false) {
                return false;
            }
            n = transform(n);
        }
        return true;
    }

    public static int transform(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2)); // false
    }
}