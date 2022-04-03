import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bai1636 {
    public static class MyNumber implements Comparable<MyNumber> {
        public int value;
        public int freq;

        public MyNumber(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public int compareTo(MyNumber o) {
            if (this.freq == o.freq) {
                return -Integer.compare(this.value, o.value);
            }
            return Integer.compare(this.freq, o.freq);
        }
    }

    public static int[] frequencySort(int[] a) {
        int[] kq = new int[a.length];

        int[] count = new int[201];
        for (int i = 0; i < a.length; i++) {
            count[a[i] + 100]++;
        }

        List<MyNumber> myList = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                MyNumber x = new MyNumber(i - 100, count[i]);
                myList.add(x);
            }
        }

        // Collections.sort(myList, new Comparator<MyNumber>() {
        // @Override
        // public int compare(MyNumber o1, MyNumber o2) {
        // return o1.compareTo(o2);
        // }
        // });
        Collections.sort(myList);

        int i = 0;
        for (MyNumber e : myList) {
            for (int j = 0; j < e.freq; j++) {
                kq[i] = e.value;
                i++;
            }
        }

        return kq;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[] { 1, 1, 2, 2, 2, 3 }))); // [3,1,1,2,2,2]
        System.out.println(Arrays.toString(frequencySort(new int[] { 2, 3, 1, 3, 2 }))); // [1,3,3,2,2]
        System.out.println(Arrays.toString(frequencySort(new int[] { -1, 1, -6, 4, 5, -6, 1, 4, 1 }))); // [5,-1,4,4,-6,-6,1,1,1]
    }
}