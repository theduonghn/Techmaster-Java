public class Bai4 {
    public static void print(int[] a, int n) {
        if (n == a.length - 1) {
            System.out.println(a[n]);
            return;
        }
        System.out.println(a[n]);
        print(a, n + 1);
    }

    public static void main(String[] args) {
        int[] a = { 1, 5, 6, 8, 9 };
        print(a, 0);
    }
}
