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
        // Reverse inputted string, check if 2 string is equal

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao mot chuoi: ");
        String string = sc.nextLine();
        String reversedString = "";
        for (int i = string.length() - 1; i >= 0; --i) {
            reversedString += string.charAt(i);
        }
        if (string.equals(reversedString)) {
            System.out.println("Chuoi da nhap la chuoi palindrome");
        } else {
            System.out.println("Chuoi da nhap khong la chuoi palindrome");
        }
        System.out.println();
    }
}
