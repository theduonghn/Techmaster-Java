import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i + 1];
            int minIndex = i + 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (min < arr[i]) {
                int t = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = { 0 };
        int[] arr3 = { 1, 5, -9, 9, 3, 2, 1, 2 };
        int[] arr4 = { 1, 1, 2, 3, 4, 4, 8, 9, 15 };
        int[] arr5 = { 1, 2, 3, 0 };
        selectionSort(arr1);
        selectionSort(arr2);
        selectionSort(arr3);
        selectionSort(arr4);
        selectionSort(arr5);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
    }
}
