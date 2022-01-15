import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    static Scanner sc = new Scanner(System.in);
    static UserService service = new UserService();
    static ArrayList<User> userList = new ArrayList<>();
    public static boolean continueProgram = true;

    public static void run() {
        menu();
    }

    public static void menu() {
        while (continueProgram) {
//            service.show(userList); // TODO: Delete this statement
            System.out.println("--------------------");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    signIn();
                    break;
                case 2:
                    service.signUp(userList);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }

    private static void signIn() {
        boolean continueLoop = true;
        while (continueLoop) {
            User user = service.signIn(userList);
            if (user != null) { // Đăng nhập thành công
                signInSuccess(user);
                continueLoop = false;
            } else { // Sai mật khẩu
                signInFail();
                continueLoop = false;
            }
        }
    }

    public static void signInSuccess(User user) {
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

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    String newUsername = service.enterAndValidateUsername(userList);
                    service.changeUsername(user, newUsername);
                    break;
                case 2:
                    String newEmail = service.enterAndValidateEmail(userList);
                    service.changeEmail(user, newEmail);
                    break;
                case 3:
                    String newPassword = service.enterAndValidatePassword(userList);
                    service.changePassword(user, newPassword);
                    break;
                case 4:
                    System.out.println("Đăng xuất thành công");
                    continueLoop = false;
                    break;
                case 0:
                    continueProgram = false;
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }

    public static void signInFail() {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("--------------------");
            System.out.println("1. Đăng nhập lại");
            System.out.println("2. Quên mật khẩu");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    continueLoop = false;
                    break;
                case 2:
                    service.forgetPassword(userList);
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }
}
