public class Bai2 {
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(5)); // 15
        System.out.println(sum(1)); // 1
    }
}
