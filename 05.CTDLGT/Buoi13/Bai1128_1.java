import java.util.HashSet;
import java.util.Set;

public class Bai1128_1 {
    /**
     * Domino
     */
    public static class Domino {
        public int x;
        public int y;

        public Domino(int[] arr) {
            x = arr[0];
            y = arr[1];
        }

        @Override
        public int hashCode() {
            if (x > y) {
                return x * 10 + y;
            }
            return y * 10 + x;
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
        Set<int[]> set = new HashSet<>();
        int[] a = { 1, 2 };
        int[] b = { 1, 2 };
        int[] c = { 2, 1 };
        set.add(a);
        set.add(b);
        System.out.println(set.size());
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        Domino dominoA = new Domino(a);
        Domino dominoB = new Domino(b);
        Domino dominoC = new Domino(c);
        System.out.println(dominoA.hashCode());
        System.out.println(dominoB.hashCode());
        System.out.println(dominoC.hashCode());

        Set<Domino> mySet = new HashSet<>();
        mySet.add(dominoA);
        mySet.add(dominoB);
        mySet.add(dominoC);
        System.out.println(mySet.size());
        System.out.println(dominoA.equals(dominoB));
        System.out.println(dominoC.equals(dominoB));
    }
}
