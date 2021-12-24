public class Main {
    public static void main(String[] args) throws Exception {
        String[] arr = StringArray.inputArray();
        System.out.println();

        StringArray.printArray(arr);
        System.out.println();

        String countedItem = "Java";
        int count = StringArray.countItem(arr, countedItem);
        System.out.printf("Chuoi \"%s\" xuat hien %d lan trong mang\n", countedItem, count);
        System.out.println();

        StringArray.getItemIndices(arr);
    }
}
