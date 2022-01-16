import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        boolean isContinue = true;
//        while (isContinue) {
//            try {
//                System.out.println("Nhập a: ");
//                int a = Integer.parseInt(sc.nextLine());
//                System.out.println("Nhập b: ");
//                int b = Integer.parseInt(sc.nextLine());
//
//                int c = b / a;
//                System.out.println(c);
//                isContinue = false;
//            } catch (ArithmeticException e) {
////                System.out.println(e.getMessage());
////                System.out.println(e.toString());
//                e.printStackTrace();
//                System.out.println("Bạn đang chia một số cho 0");
//            } catch (NumberFormatException e) {
//                System.out.println("Bạn phải nhập số");
//            } finally {
//                System.out.println("Tạm biệt");
//            }
//        }

        while (true) {
            System.out.println("Nhập tuổi");
            try {
                int age = sc.nextInt();
                Valitdate.validateAge(age);
                break;
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }
}
