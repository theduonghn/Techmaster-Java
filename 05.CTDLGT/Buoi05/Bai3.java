public class Bai3 {
    public static int sum(int a, int b) {
        // a <= b;
        if (b == a) {
            return b;
        }
        return b + sum(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(5, 10)); // 45
        System.out.println(sum(1, 8)); // 36
    }
}
