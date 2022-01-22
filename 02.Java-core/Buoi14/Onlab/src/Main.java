import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import javax.sound.sampled.SourceDataLine;

public class Main {
    public static void main(String[] args) throws Exception {
        // List<String> list = new ArrayList<>();
        // list.add("Hanoi");
        // System.out.println(list.contains("hanoi"));
        // System.out.println(list.contains("Hanoi"));

        // List<Integer> list = new ArrayList<>();
        // list.add(3);
        // list.add(5);
        // list.add(7);
        // list.add(2);
        // list.add(4);

        // Iterator<Integer> iterator = list.iterator();
        // while (iterator.hasNext()) {
        // System.out.println(iterator.next());
        // }

        // Queue<Integer> listInt = new LinkedList<>();
        // listInt.add(5);
        // // listInt.add("hello");
        // listInt.offer(7);
        // // listInt.offer("10");
        // listInt.offer(3);
        // listInt.offer(1);
        // System.out.println(listInt);
        // listInt.remove();
        // System.out.println(listInt);

        // Queue<Integer> list = new PriorityQueue<>();
        // list.add(3);
        // list.add(1);
        // list.add(5);
        // list.add(8);
        // list.add(3);
        // list.add(0);
        // System.out.println(list);
        // list.remove();
        // System.out.println(list);

        // Set<Integer> list = new HashSet<>();
        // list.add(3);
        // list.add(1);
        // list.add(5);
        // list.add(8);
        // list.add(3);
        // list.add(0);
        // System.out.println(list);

        Map<Integer, String> map = new HashMap<>();
        map.put(4, "Van");
        map.put(1, "Linh");
        map.put(2, "Ngoc");
        map.put(3, "San");
        map.put(3, "Ha");
        System.out.println(map);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
