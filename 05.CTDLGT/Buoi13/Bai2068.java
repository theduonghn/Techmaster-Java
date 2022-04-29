import java.util.HashMap;
import java.util.Map;

public class Bai2068 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (char key : map.keySet()) {
            if (Math.abs(map.get(key)) > 3) {
                return false;
            }
        }
        return true;
    }
}
