import java.util.HashMap;
import java.util.Map;

public class Bai1128 {
    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            String s = convert(domino);
            map.put(s, map.getOrDefault(s, 0) + 1);
            count += map.get(s) - 1;
        }
        return count;
    }

    public static String convert(int[] domino) {
        if (domino[0] <= domino[1]) {
            return "" + domino[0] + domino[1];
        } else {
            return "" + domino[1] + domino[0];
        }
    }

    public static void main(String[] args) {
        // System.out.println(numEquivDominoPairs(new int[][] {
        // { 1, 2 },
        // { 2, 1 },
        // { 3, 4 },
        // { 5, 6 },
        // }));
        System.out.println(numEquivDominoPairs(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 }, }));
    }
}