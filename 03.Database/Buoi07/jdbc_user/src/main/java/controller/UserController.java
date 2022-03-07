package controller;

import model.User;
import service.UserService;

import java.util.Scanner;

public class UserController {
    Scanner sc = new Scanner(System.in);
    UserService service = new UserService();
    public boolean continueProgram = true;

    public void run() {
        menu();
    }

    public void menu() {
        while (continueProgram) {
            System.out.println("--------------------");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> signIn();
                    case 2 -> service.signUp();
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void signIn() {
        boolean continueLoop = true;
        while (continueLoop) {
            User user = service.signIn();
            if (user != null) { // Đăng nhập thành công
                signInSuccess(user);
            } else { // Sai mật khẩu
                signInFail();
            }
            continueLoop = false;
        }
    }

    public void signInSuccess(User user) {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("--------------------");
            System.out.println("Chào mừng " + user.getUsername() + ", bạn có thể thực hiện các công việc sau:");
            System.out.println("1. Thay đổi username");
            System.out.println("2. Thay đổi email");
            System.out.println("3. Thay đổi mật khẩu");
            System.out.println("4. Đăng xuất");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        String newUsername = service.enterAndValidateUsername();
                        service.changeUsername(user, newUsername);
                    }
                    case 2 -> {
                        String newEmail = service.enterAndValidateEmail();
                        service.changeEmail(user, newEmail);
                    }
                    case 3 -> {
                        String newPassword = service.enterAndValidatePassword();
                        service.changePassword(user, newPassword);
                    }
                    case 4 -> {
                        System.out.println("Đăng xuất thành công");
                        continueLoop = false;
                    }
                    case 0 -> {
                        continueProgram = false;
                        continueLoop = false;
                    }
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void signInFail() {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("--------------------");
            System.out.println("1. Đăng nhập lại");
            System.out.println("2. Quên mật khẩu");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> continueLoop = false;
                    case 2 -> {
                        service.forgetPassword();
                        continueLoop = false;
                    }
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
