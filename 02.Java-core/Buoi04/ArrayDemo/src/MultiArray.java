import javax.sound.sampled.SourceDataLine;

public class MultiArray {
    public static void createArray() {
        int[][] arr = new int[3][2];
        arr[0][0] = 9;
        arr[0][1] = 7;
        arr[1][0] = 4;
        arr[1][1] = 3;
        arr[2][0] = 1;
        arr[2][1] = 6;

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] createSquareArray() {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println("Ma tran vuong vua tao: ");
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr;
    }

    public static void layDuongCheoChinh(int[][] arr) {
        System.out.println("Duong cheo chinh: ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i][i] + "\t");
        }
        System.out.println();
    }
}
