import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhập một số nguyên hoặc nhập \"q\" hoặc \"x\" để thoát: ");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("x")) {
                    break;
                }
                int a = Integer.parseInt(input);
                if (Util.isPrimeNumber(a)) {
                    System.out.println(a + " là số nguyên tố");
                } else {
                    System.out.println(a + " không phải là số nguyên tố");
                }
            } catch (NumberFormatException e) {
                System.out.println("Phải nhập số nguyên");
            }
        }
    }
}
