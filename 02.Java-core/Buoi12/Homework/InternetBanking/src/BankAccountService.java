import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountService {
    static final Scanner sc = new Scanner(System.in);

    public boolean login(BankAccount account) {


        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();

        if (phoneNumber.equals(account.getPhoneNumber()) && password.equals(account.getPassword())) {
            System.out.println("Đăng nhập thành công");
            return true;
        } else {
            System.out.println("Kiểm tra lại số điện thoại và mật khẩu");
            return false;
        }
    }
}
