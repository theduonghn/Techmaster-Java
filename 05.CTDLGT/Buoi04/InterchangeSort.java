import java.util.Arrays;

public class InterchangeSort {
    public static void interchangeSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = { 0 };
        int[] arr3 = { 1, 5, -9, 9, 3, 2, 1, 2 };
        int[] arr4 = { 1, 1, 2, 3, 4, 4, 8, 9, 15 };
        int[] arr5 = { 1, 2, 3, 0 };
        interchangeSort(arr1);
        interchangeSort(arr2);
        interchangeSort(arr3);
        interchangeSort(arr4);
        interchangeSort(arr5);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
    }
}
