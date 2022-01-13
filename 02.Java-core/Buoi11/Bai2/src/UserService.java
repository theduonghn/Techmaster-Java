import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    public ArrayList<User> createUserList() {
        return new ArrayList<User>();
    }

    public User signUp(ArrayList<User> userList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập username: ");
        String username = sc.nextLine();
        System.out.print("Nhập password: ");
        String password = sc.nextLine();
        User user = new User(username, password);
        userList.add(user);
        return user;
    }

    public void signIn(ArrayList<User> userList) {
        boolean isSuccessfulSignIn = false;
        while (!isSuccessfulSignIn) {
            User user;
            String username;
            boolean isValidUsername = false;
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập username: ");
            username = sc.nextLine();
            while (!isValidUsername) {
                for (User u : userList) {
                    if (u.getUsername().equals(username)) {
                        isValidUsername = true;
                        user = u;
                    }
                }
                // Invalid username
                System.out.println("Kiểm tra lại username");
                user = null;
                continue;
            }

            System.out.print("Nhập password: ");
            String password = sc.nextLine();
            if (user.getPassword().equals(password)) {
                isSuccessfulSignIn = true;
            }
        }
    }
}
