import java.util.Scanner;

public class ArrayExample {
    public static int[] createArray() {
        int[] intArray = new int[5];
        intArray[0] = 1;
        intArray[1] = 5;
        intArray[2] = 7;
        intArray[3] = 2;
        intArray[4] = 6;

        return intArray;
    }

    public static int[] inputArray() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; ++i) {
            System.out.print("Nhap phan tu thu " + i + ": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
