import java.util.Scanner;

public class ScannerExample {
    public static void usingScanner() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten ban: ");
        String name = sc.nextLine();
        System.out.println("Ten toi la: " + name);

        System.out.println("Nhap tuoi cua ban: ");
        int age = Integer.parseInt(sc.nextLine());
        // sc.nextLine();

        System.out.println("Nhap dia chi: ");
        String address = sc.nextLine();

        System.out.printf("Ten toi la %s, toi %d tuoi, toi den tu %s\n", name, age, address);
    }
}
