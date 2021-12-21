import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        // System.out.println("Nhap chieu cao: ");
        // double height = Double.parseDouble(sc.nextLine());
        // System.out.println("Nhap can nang: ");
        // double weight = Double.parseDouble(sc.nextLine());
        // double bmi = weight / (height * height);
        // System.out.println(bmi);
        // if (bmi < 18.5) {
        // System.out.println("Thieu can");
        // } else if (bmi <= 24.9) {
        // System.out.println("Can doi");
        // } else {
        // System.out.println("Thua can");
        // }

        // System.out.print("Nhap canh a = ");
        // double a = Double.parseDouble(sc.nextLine());
        // System.out.print("Nhap canh b = ");
        // double b = Double.parseDouble(sc.nextLine());
        // System.out.print("Nhap canh c = ");
        // double c = Double.parseDouble(sc.nextLine());

        // if (a + b <= c) {
        // System.out.println("a, b, c khong phai 3 canh tam giac");
        // } else if (a + c <= b) {
        // System.out.println("a, b, c khong phai 3 canh tam giac");
        // } else if (b + c <= a) {
        // System.out.println("a, b, c khong phai 3 canh tam giac");
        // } else {
        // System.out.println("a, b, c la 3 canh tam giac");
        // }

        // if ((a + b > c) && (a + c > b) && (b + c > a)) {
        // System.out.println("a, b, c la 3 canh tam giac");
        // } else {
        // System.out.println("a, b, c khong phai 3 canh tam giac");
        // }

        // int rdNum = rd.nextInt(10);
        // System.out.println(rdNum);

        // switch (rdNum) {
        // case 2:
        // System.out.println("Thu 2");
        // break;
        // case 3:
        // System.out.println("Thu 3");
        // break;
        // case 4:
        // System.out.println("Thu 4");
        // break;
        // case 5:
        // System.out.println("Thu 5");
        // break;
        // case 6:
        // System.out.println("Thu 6");
        // break;
        // case 7:
        // System.out.println("Thu 7");
        // break;
        // case 8:
        // System.out.println("Chu nhat");
        // break;
        // default:
        // System.out.println("Khong co ngay nay trong tuan");
        // }

        // System.out.print("Nhap thang: ");
        // int month = Integer.parseInt(sc.nextLine());
        // switch (month) {
        // case 1, 3, 5, 7, 8, 10, 12:
        // System.out.println("Thang co 31 ngay");
        // break;
        // case 2:
        // System.out.println("Thang co 28 hoac 29 ngay");
        // break;
        // case 4, 6, 9, 11:
        // System.out.println("Thang co 30 ngay");
        // break;
        // default:
        // System.out.println("Khong co thang nay");
        // }

        // System.out.println("Hello world");
        // System.out.println("Hello world");
        // System.out.println("Hello world");
        // System.out.println("Hello world");
        // System.out.println("Hello world");
        // System.out.println("Hello world");
        // System.out.println("Hello world");
        // System.out.println("Hello world");
        // System.out.println("Hello world");
        // System.out.println("Hello world");

        // for (int i = 1; i <= 10; ++i) {
        // System.out.println("Hello World");
        // }

        // for (int i = 1; i <= 10; ++i) {
        // System.out.println("Dong thu " + i);
        // }

        // for (int i = 1; i <= 100; ++i) {
        // if (i % 3 == 0 && i % 5 == 0) {
        // System.out.println("FizzBuzz");
        // } else if (i % 3 == 0) {
        // System.out.println("Fizz");
        // } else if (i % 5 == 0) {
        // System.out.println("Buzz");
        // } else {
        // System.out.println(i);
        // }
        // }

        // int rdNumber = 0;
        // int count = 0;

        // while (rdNumber < 10) {
        // rdNumber = rd.nextInt(12);
        // System.out.println(rdNumber);
        // ++count;
        // }

        // System.out.println("So lan lap: " + count);

        // double height;
        // do {
        // System.out.print("Nhap chieu cao: ");
        // height = Double.parseDouble(sc.nextLine());
        // } while (height < .1 || height > 2.5);

        // double weight;
        // do {
        // System.out.print("Nhap can nang: ");
        // weight = Double.parseDouble(sc.nextLine());
        // } while (weight < 1 || weight > 100);

        // double bmi = weight / (height * height);
        // System.out.println(bmi);
        // if (bmi < 18.5) {
        // System.out.println("Thieu can");
        // } else if (bmi <= 24.9) {
        // System.out.println("Can doi");
        // } else {
        // System.out.println("Thua can");
        // }

        int rdNumber = rd.nextInt(100);
        int number;

        boolean continueGame = true;
        do {
            System.out.print("Doan so: ");
            number = Integer.parseInt(sc.nextLine());
            if (number == rdNumber) {
                System.out.println("Ban doan dung roi");
                continueGame = false;
            } else if (number > rdNumber) {
                System.out.println("Ban doan lon hon roi");
            } else {
                System.out.println("Ban doan nho hon roi");
            }
        } while (continueGame);
    }
}
