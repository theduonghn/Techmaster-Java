import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // int[] intArray = new int[5];

        // System.out.println("Mang vua tao: ");
        // for (int i = 0; i < intArray.length; i += 1) {
        // System.out.print(intArray[i] + "\t");
        // }

        // String[] strArray = new String[5];
        // strArray[0] = "Java";
        // strArray[1] = "HTML/CSS";
        // strArray[2] = "JS";
        // strArray[3] = "MySQL";
        // strArray[4] = "Python";

        // for (int i = 0; i < strArray.length; i += 1) {
        // System.out.println(strArray[i]);
        // }

        // for (int i = 0; i < intArray.length; i += 1) {
        // if (intArray[i] % 2 == 0) {
        // System.out.println(intArray[i]);
        // }
        // }

        // int max = intArray[0];
        // int min = intArray[1];
        // for (int i = 0; i < intArray.length; ++i) {
        // if (intArray[i] < min) {
        // min = intArray[i];
        // }
        // if (intArray[i] > max) {
        // max = intArray[i];
        // }
        // }
        // System.out.println("max: " + max);
        // System.out.println("min: " + min);

        // for (int i = 0; i < intArray.length; ++i) {
        // for (int j = i + 1; j < intArray.length; ++j) {
        // if (intArray[j] > intArray[i]) {
        // int temp = intArray[j];
        // intArray[j] = intArray[i];
        // intArray[i] = temp;
        // }
        // }
        // }
        // for (int i = 0; i < intArray.length; ++i) {
        // System.out.print(intArray[i] + "\t");
        // }
        // System.out.println();

        // int[] arr = ArrayExample.inputArray();
        // ArrayExample.printArray(arr);

        // MultiArray.createArray();
        // System.out.println();
        // MultiArray.createSquareArray();

        // String[] strArray = { "Pham", "The", "Duong" };
        // String str = Arrays.toString(strArray);
        // System.out.println(str);

        int[][] arr = MultiArray.createSquareArray();
        MultiArray.layDuongCheoChinh(arr);
    }
}
