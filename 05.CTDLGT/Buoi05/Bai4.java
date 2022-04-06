public class Bai4 {
    public static void print(int[] a, int n) {
        if (n == a.length - 1) {
            System.out.println(a[n]);
            return;
        }
        System.out.println(a[n]);
        print(a, n + 1);
    }

    public static void printRow(int[][] a, int n) {
        if (n == a.length - 1) {
            print(a[n], 0);
            return;
        }
        print(a[n], 0);
        printRow(a, n + 1);
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };
        printRow(a, 0);
    }
}
