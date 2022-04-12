public class Bai1572 {
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (2 * i == n - 1) {
                sum += mat[i][i];
            } else {
                sum += mat[i][i] + mat[i][n - i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat;
        mat = new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 4, 5, 6 },
                new int[] { 7, 8, 9 }
        };
        System.out.println(diagonalSum(mat)); // 25
        mat = new int[][] {
                new int[] { 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1 }
        };
        System.out.println(diagonalSum(mat)); // 8
        mat = new int[][] {
                new int[] { 5 }
        };
        System.out.println(diagonalSum(mat)); // 5
    }
}
