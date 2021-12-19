import java.util.Scanner;

public class StringComparison {
    // This class contains methods to compare string

    public static void compareString() {
        // Crreate scanner
        Scanner sc = new Scanner(System.in);

        // Input 2 strings
        System.out.println("Nhap chuoi thu nhat: ");
        String string1 = sc.nextLine();
        System.out.println("Nhap chuoi thu hai: ");
        String string2 = sc.nextLine();
        String resultContent = compareContent(string1, string2) ? "Hai chuoi bang nhau" : "Hai chuoi khong bang nhau";
        String resultLength = compareLength(string1, string2) ? "Hai chuoi co do dai bang nhau"
                : "Hai chuoi co do dai khong bang nhau";
        System.out.println(resultContent);
        System.out.println(resultLength);
    }

    public static boolean compareContent(String a, String b) {
        return a.equals(b);
    }

    public static boolean compareLength(String a, String b) {
        return a.length() == b.length();
    }
}