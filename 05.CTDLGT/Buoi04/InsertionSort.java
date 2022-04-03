import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int pick = arr[i + 1];
            boolean pickInserted = false;
            for (int j = i + 1; j >= 1; j--) {
                if (pick < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = pick;
                    pickInserted = true;
                    break;
                }
            }
            if (!pickInserted) {
                arr[0] = pick;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = { 0 };
        int[] arr3 = { 1, 5, -9, 9, 3, 2, 1, 2 };
        int[] arr4 = { 1, 1, 2, 3, 4, 4, 8, 9, 15 };
        int[] arr5 = { 1, 2, 3, 0 };
        insertionSort(arr1);
        insertionSort(arr2);
        insertionSort(arr3);
        insertionSort(arr4);
        insertionSort(arr5);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
    }
}
