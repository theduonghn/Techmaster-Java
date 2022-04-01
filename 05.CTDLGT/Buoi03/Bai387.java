import java.util.HashMap;
import java.util.Map;

public class Bai387 {
    public static int firstUniqChar(String s) {
        Map<Character, int[]> counter = new HashMap<>();
        // key: character;
        // value: array of 2 element,
        // first element is index where character occurs the first time,
        // second element is number of that character

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counter.containsKey(c)) {
                counter.get(c)[1]++;
            } else {
                counter.put(c, new int[] { i, 1 });
            }
        }

        int resultIndex = -1;
        for (Map.Entry<Character, int[]> set : counter.entrySet()) {
            int[] value = set.getValue();
            if (value[1] == 1 && (resultIndex == -1 || value[0] < resultIndex)) {
                resultIndex = value[0];
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode")); // 0
        System.out.println(firstUniqChar("loveleetcode")); // 2
        System.out.println(firstUniqChar("aabb")); // -1
    }
}