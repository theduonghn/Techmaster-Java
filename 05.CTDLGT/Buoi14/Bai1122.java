import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Bai1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> result = new LinkedList<>();
        List<Integer> diff = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet();
        for (int e : arr2) {
            set.add(e);
        }

        for (int e : arr1) {
            if (set.contains(e)) {
                map.put(e, map.getOrDefault(e, 0) + 1);
            } else {
                diff.add(e);
            }
        }

        for (int e : arr2) {
            if (map.containsKey(e)) {
                int value = map.get(e);
                for (int i = 0; i < value; i++) {
                    result.add(e);
                }
            }

        }

        Collections.sort(diff);
        result.addAll(diff);

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = result.get(i);
        }
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, new int[] {
                2, 1, 4, 3, 9, 6 })));
    }
}