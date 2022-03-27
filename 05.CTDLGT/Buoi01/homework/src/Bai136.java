import java.util.HashMap;
import java.util.Map;

public class Bai136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> set : counter.entrySet()) {
            if (set.getValue() == 1) {
                return set.getKey();
            }
        }
        return 0;
    }
}