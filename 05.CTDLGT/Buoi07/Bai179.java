import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bai179 {
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        List<String> strNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strNums.add(String.valueOf(nums[i]));
        }

        Collections.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1 + o2).compareTo(o2 + o1);
            }

        });

        String t = String.join("", strNums);
        String result = "";
        for (int i = 0; i < t.length(); i++) {
            if (result.equals("") && t.charAt(i) == '0') {
                continue;
            } else {
                result += t.charAt(i);
            }
        }

        if (result.equals("")) {
            result = "0";
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] { 10, 2 })); // 210
        System.out.println(largestNumber(new int[] { 13, 30, 34, 5, 9 })); // 95343103
        System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 })); // 9534330
        System.out.println(largestNumber(new int[] { 0, 0 })); // 0
    }
}
