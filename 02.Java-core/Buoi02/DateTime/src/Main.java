import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Main {
    public static final double PI = 3.14;

    public static void main(String[] args) throws Exception {
        LocalDate today = LocalDate.now();
        // System.out.println(today);
        // System.out.println(today.getDayOfMonth());
        // System.out.println(today.getDayOfWeek());
        // System.out.println(today.getDayOfYear());

        // System.out.println(today.getMonth());
        // System.out.println(today.getMonthValue());

        // System.out.println(today.getYear());

        // LocalDate tomorrow = today.plusDays(1);
        // System.out.println("Ngày mai: " + tomorrow);

        // LocalDate yesterday = today.minusDays(1);
        // System.out.println("Hôm qua: " + yesterday);

        // yesterday = today.plusDays(-1);
        // System.out.println("Hôm qua: " + yesterday);

        // LocalDate date = LocalDate.of(2021, 2, 25);
        // System.out.println(date);

        // LocalDate currentDate = LocalDate.of(2019, Month.DECEMBER, 20);
        // System.out.println(currentDate);

        LocalTime time = LocalTime.now();
        // System.out.println(time);

        // LocalTime time2 = LocalTime.of(3, 45, 59);
        // System.out.println(time2);

        // System.out.println(time.getHour());
        // System.out.println(time.getMinute());
        // System.out.println(time.getSecond());
        // System.out.println(time.getNano());

        // System.out.println(time.plusMinutes(100));
        // System.out.println(time.plusHours(3));
        // System.out.println(time.minusHours(5));

        // LocalDateTime dateTime = LocalDateTime.now();
        // System.out.println(dateTime);

        // LocalDateTime dateTime2 = LocalDateTime.of(2021, 12, 18, 19, 18, 0);
        // System.out.println(dateTime2);

        // LocalDateTime dateTime3 = LocalDateTime.of(today, time);
        // System.out.println(dateTime3);

        // DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // System.out.println(dateTime.format(myFormat));

        // myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // System.out.println(dateTime.format(myFormat));

        // myFormat = DateTimeFormatter.ofPattern("dd-mm-yyyy"); // mm nhỏ -> in ra phút
        // System.out.println(dateTime.format(myFormat));

        // System.out.println(PI);

        // System.out.println("Duong: \"Hello World!\"");
        // System.out.println("abcd\b");
        // System.out.println("abcd\b e");
        // System.out.println("abcd\be");

        // System.out.println(div(9, 4));

        // ScannerExample.usingScanner();
        // System.out.print("Xin chao");
        // System.out.print("Xin chao");

        // System.out.println("Xin chao");
        // System.out.println("Xin chao");

        // System.out.printf("Ki tu %c, chuoi %s, so nguyen %d\n", 'a', "string", 24);
        // System.out.format("Ki tu %c, chuoi %s, so nguyen %d\n", 'a', "string", 24);

        // // Căn lề
        // System.out.printf("%12s%12d%16s\n", "Duong", 24, "Ha Noi");
        // System.out.printf("%12s%12d%16s\n", "Ngoc", 25, "Ha Giang");
        // System.out.printf("%12s%12d%16s\n", "The Anh", 29, "Ho Chi Minh");

        // int i = 5;
        // int j = i++;
        // System.out.println(i);
        // System.out.println(j);
        // i += 1;
        // System.out.println(i);

        // Scanner sc = new Scanner(system.in);
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        // System.out.println("Nhap so: ");
        // int number = sc.nextInt();

        // String rs = number % 2 == 0 ? number + " la so chan" : number + " la so le";
        // System.out.println(rs);

        // int randomNumber = rd.nextInt(100);
        // String rs = randomNumber % 2 == 0 ? randomNumber + " la so chan" :
        // randomNumber + " la so le";
        // System.out.println(rs);

        // int randomNum = rd.nextInt(10);
        // System.out.println("Nhap so: ");
        // int num = sc.nextInt();
        // String result = randomNum == num ? System.out.printf("2 so %d và %d bang
        // nhau", randomNum, num)
        // : System.out.printf("2 so %d và %d khong bang nhau", randomNum, num);

        double canhGocVuong1 = 3.0;
        double canhGocVuong2 = 4.0;

        System.out.println(Math.pow(2, canhGocVuong1));
        System.out.println(Math.pow(2, canhGocVuong2));
        double canhHuyen = Math.sqrt(Math.pow(2, canhGocVuong1) + Math.pow(2,
                canhGocVuong2));
        System.out.println(canhHuyen);
        System.out.println(Math.pow(canhGocVuong1, 2));
        System.out.println(Math.pow(canhGocVuong2, 2));
        canhHuyen = Math.sqrt(Math.pow(canhGocVuong1, 2) + Math.pow(
                canhGocVuong2, 2));
        System.out.println(canhHuyen);
        canhHuyen = Math.sqrt(canhGocVuong1 * canhGocVuong1 + canhGocVuong2 * canhGocVuong2);
        System.out.println(canhHuyen);
    }

    public static double div(int a, int b) {
        return (double) a / b;
    }
}
