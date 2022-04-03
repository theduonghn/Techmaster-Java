import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
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
        bubbleSort(arr1);
        bubbleSort(arr2);
        bubbleSort(arr3);
        bubbleSort(arr4);
        bubbleSort(arr5);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
    }
}
