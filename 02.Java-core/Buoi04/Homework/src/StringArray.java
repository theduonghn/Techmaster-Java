import java.util.Scanner;

public class StringArray {
    public static String[] inputArray() {
        // Create an array by input the number of elements, and each element from
        // keyboard
        Scanner sc = new Scanner(System.in);
        System.out.println("Tao mang bang cach nhap tu ban phim");
        System.out.print("Nhap so phan tu cua mang: ");
        int n = Integer.parseInt(sc.nextLine()); // The number of elements
        String[] arr = new String[n];
        for (int i = 0; i < n; ++i) {
            System.out.print("Nhap phan tu thu " + i + ": ");
            arr[i] = sc.nextLine();
        }
        return arr;
    }

    public static void printArray(String[] arr) {
        // Print elements of array
        System.out.println("Cac phan tu cua mang: ");
        for (String element : arr) {
            System.out.print(element + "\t");
        }
        System.out.println();
    }

    public static int countItem(String[] arr, String item) {
        // Count the times that an item occurs in array
        int count = 0;
        for (String element : arr) {
            if (element.equals(item)) {
                count += 1;
            }
        }
        return count;
    }

    public static void getItemIndices(String[] arr) {
        // Get the indices of an item (input from keyboard) in array

        // Input item
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi can tim vi tri: ");
        String item = sc.nextLine();

        int count = 0; // Count the times that item occurs in array
        String result = "Chuoi \"" + item + "\" khong xuat hien trong mang";
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].equals(item)) {
                count += 1;
                if (count == 1) {
                    result = "Chuoi \"" + item + "\" xuat hien tai vi tri: " + i;
                } else {
                    result += ", " + i;
                }
            }
        }
        System.out.println(result);
    }
}
