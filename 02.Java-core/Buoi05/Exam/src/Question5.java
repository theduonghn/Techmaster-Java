import java.util.Scanner;

public class Question5 {
    public static String formatName(String name) {
        String[] words = name.trim().split("\s+");
        for (int i = 0; i < words.length; ++i) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        String formattedName = "";
        for (String word : words) {
            formattedName += word + " ";
        }
        formattedName = formattedName.trim();
        return formattedName;
    }

    public static void printFormattedName(String name) {
        String formattedName = formatName(name);
        System.out.println("Ten da duoc chuan hoa: ");
        System.out.println(formattedName);
        System.out.println();
    }

    public static void checkInputtedStringIsPalindrome() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao mot chuoi: ");
        String string = sc.nextLine();
        boolean isPalindrome = true;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Chuoi da nhap la chuoi palindrome");
        } else {
            System.out.println("Chuoi da nhap khong la chuoi palindrome");
        }
        System.out.println();
    }
}
