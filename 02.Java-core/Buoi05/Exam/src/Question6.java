import java.util.Scanner;

public class Question6 {
    public static int[][] input2DArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap mang 2 chieu: ");
        System.out.print("Nhap so hang: ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap so cot: ");
        int col = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.printf("Nhap phan tu [%d][%d]: ", i, j);
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println();
        return arr;
    }

    public static void print2DArray(int[][] arr) {
        System.out.println("Cac phan tu cua mang 2 chieu: ");
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSquareMatrix(int[][] arr) {
        // Check if number of rows equals to number of columns
        return arr.length == arr[0].length;
    }

    public static void printMainDiagonal(int[][] arr) {
        if (isSquareMatrix(arr)) {
            System.out.println("Cac phan tu nam tren duong cheo chinh cua mang 2 chieu: ");
            for (int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i][i] + "\t");
            }
            System.out.println();
        } else {
            System.out.println("Mang 2 chieu khong phai ma tran vuong nen khong co duong cheo chinh");
        }
    }
}
