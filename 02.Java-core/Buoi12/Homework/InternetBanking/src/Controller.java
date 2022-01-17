import util.MyFormat;

import java.util.Scanner;

public class Controller {
    static Scanner sc = new Scanner(System.in);
    static BankAccountService bankAccountService = new BankAccountService();
    static TransactionService transactionService = new TransactionService();
    static BankAccount account = new BankAccount("0123456789", "123456", 5000000L);
    static boolean continueProgram = true;

    public static void run() {
        menu();
    }

    public static void menu() {
        while (continueProgram) {
            try {
                System.out.println("--------------------");
                System.out.println("1. Đăng nhập");
                System.out.println("2. Thoát chương trình");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public static void login() {
        boolean success = bankAccountService.login(account);
        if (success) {
            loginSuccess();
        }
    }

    public static void loginSuccess() {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("--------------------");
                System.out.println("1. Truy vấn số dư tài khoản");
                System.out.println("2. Chuyển tiền");
                System.out.println("3. Xem lịch sử giao dịch");
                System.out.println("4. Thoát chương trình");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Số dư tài khoản là: " + MyFormat.formatVnd(account.getBalance()));
                        break;
                    case 2:
                        transactionService.transact(account);
                        break;
                    case 3:
                        System.out.println("Lịch sử giao dịch: ");
                        transactionService.showTransactions(account);
                        break;
                    case 4:
                        continueProgram = false;
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
