import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bai2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        addToMap(nums1, map);
        addToMap(nums2, map);
        addToMap(nums3, map);

        List<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) >= 2) {
                result.add(key);
            }
        }
        return result;
    }

    public void addToMap(int[] nums, Map<Integer, Integer> map) {
        Set<Integer> added = new HashSet<>();
        for (int num : nums) {
            if (!added.contains(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                added.add(num);
            }
        }
    }
}