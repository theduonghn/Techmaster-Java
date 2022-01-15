import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {
    public static final Scanner sc = new Scanner(System.in);

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[A-Z])(?=.*[.,-_;])(?=\\S+$).{7,15}$");
    /*
    ^                 # start-of-string
    (?=.*[A-Z])       # an upper case letter must occur at least once
    (?=.*[.,-_;])     # a special character must occur at least once
    (?=\S+$)          # no whitespace allowed in the entire string
    .{7,15}           # from 7 to 15 characters
    $                 # end-of-string
    */

    public boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public boolean validatePassword(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    public boolean usernameInList(ArrayList<User> userList, String username) {
        // Check if username is used or not
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean emailInList(ArrayList<User> userList, String email) {
        // Check if email is used or not
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public String enterAndValidateUsername(ArrayList<User> userList) {
        while (true) {
            System.out.print("Nhập username: ");
            String username = sc.nextLine();

            if (usernameInList(userList, username)) {
                System.out.println("Username đã được sử dụng");
            } else {
                return username;
            }
        }
    }

    public String enterAndValidateEmail(ArrayList<User> userList) {
        while (true) {
            System.out.print("Nhập email: ");
            String email = sc.nextLine();

            if (!validateEmail(email)) {
                System.out.println("Email không hợp lệ");
            } else if (emailInList(userList, email)) {
                System.out.println("Email đã được sử dụng");
            } else {
                return email;
            }
        }
    }

    public String enterAndValidatePassword(ArrayList<User> userList) {
        while (true) {
            System.out.print("Nhập password: ");
            String password = sc.nextLine();

            if (validatePassword(password)) {
                return password;
            } else {
                System.out.println("Password không hợp lệ");
            }
        }
    }

    public void show(ArrayList<User> userList) {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public User signUp(ArrayList<User> userList) {
        String username = enterAndValidateUsername(userList);
        String email = enterAndValidateEmail(userList);
        String password = enterAndValidatePassword(userList);

        User newUser = new User(username, email, password);
        userList.add(newUser);

        return newUser;
    }

    public User signIn(ArrayList<User> userList) {
        // Nếu đăng nhập thành công trả về user
        // Nếu không, trả về null

        boolean signInSuccessful = false;
        String username = null;
        String password;

        // Check username
        while (true) {
            System.out.print("Nhập username: ");
            username = sc.nextLine();
            if (usernameInList(userList, username)) {
                break;
            }
            System.out.println("Kiểm tra lại username");
        }

        // Check password
        User user = getUserByUsername(userList, username);
        if (user == null) {
            System.out.println("Username không tồn tại");
            return null;
        } else {
            System.out.print("Nhập password: ");
            password = sc.nextLine();
            if (user.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công");
                return user;
            } else {
                System.out.println("Sai mật khẩu");
                return null;
            }
        }
    }

    public void forgetPassword(ArrayList<User> userList) {
        System.out.print("Nhập email: ");
        String email = sc.nextLine();
        if (emailInList(userList, email)) {
            String newPassword = enterAndValidatePassword(userList);
            User user = getUserByEmail(userList, email);
            changePassword(user, newPassword);
        } else {
            System.out.println("Chưa tồn tại tài khoản");
        }
    }

    public User getUserByUsername(ArrayList<User> userList, String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByEmail(ArrayList<User> userList, String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void changeUsername(User user, String newUsername) {
        user.setUsername(newUsername);
    }

    public void changeEmail(User user, String newEmail) {
        user.setEmail(newEmail);
    }

    public void changePassword(User user, String newPassword) {
        user.setPassword(newPassword);
    }
}
