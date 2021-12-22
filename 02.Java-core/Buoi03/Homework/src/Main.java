import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Question 1
        System.out.println("Cau 1");
        char targetChar = 'o';
        String sentence = "You only live once, but if you do it right, once is enough.";
        int count = 0;
        for (int i = 0; i < sentence.length(); i += 1) {
            if (sentence.charAt(i) == targetChar) {
                count += 1;
                System.out.printf("Ky tu \'%c\' xuat hien tai vi tri %d\n", targetChar, i);
            }
        }
        System.out.printf("Ky tu \'%c\' da xuat hien tong cong %d lan\n", targetChar, count);
        System.out.println();

        // Question 2
        Scanner sc = new Scanner(System.in);
        System.out.println("Cau 2");
        System.out.println("Giai phuong trinh bac nhat ax + b = 0");
        System.out.print("Nhap a: ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap b: ");
        double b = Double.parseDouble(sc.nextLine());
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh co vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            double rootOfEquation = -b / a;
            System.out.printf("Nghiem phuong trinh la: %.2f\n", rootOfEquation);
        }
    }
}
