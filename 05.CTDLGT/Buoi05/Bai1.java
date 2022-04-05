public class Bai1 {
    public static int search(int[] a, int num, int i) {
        if (i > a.length - 1) {
            return -1;
        }
        if (a[i] == num) {
            return i;
        }
        return search(a, num, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 1, 3, 5, 7 }, 3, 0)); // 1
        System.out.println(search(new int[] { 3, 5, 7, 3 }, 3, 0)); // 0
        System.out.println(search(new int[] { 1, 3, 5, 7, 3 }, 2, 0)); // -1
    }
}