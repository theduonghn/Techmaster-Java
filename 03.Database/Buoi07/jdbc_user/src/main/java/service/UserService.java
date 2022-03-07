package service;

import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn = connectDatabase.connect();

    Scanner sc = new Scanner(System.in);

    Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*[A-Z])(?=.*[.,-_;])(?=\\S+$).{7,15}$");
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

    public boolean usernameInList(String username) {
        // Check if username is used or not
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet.next(); // return true if list has at least one element
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean emailInList(String email) {
        // Check if email is used or not
        String query = "SELECT * FROM users WHERE email = '" + email + "'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet.next(); // return true if list has at least one element
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String enterAndValidateUsername() {
        while (true) {
            System.out.print("Nhập username: ");
            String username = sc.nextLine();

            if (usernameInList(username)) {
                System.out.println("Username đã được sử dụng");
            } else {
                return username;
            }
        }
    }

    public String enterAndValidateEmail() {
        while (true) {
            System.out.print("Nhập email: ");
            String email = sc.nextLine();

            if (!validateEmail(email)) {
                System.out.println("Email không hợp lệ");
            } else if (emailInList(email)) {
                System.out.println("Email đã được sử dụng");
            } else {
                return email;
            }
        }
    }

    public String enterAndValidatePassword() {
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
        userList.forEach(System.out::println);
    }

    public void signUp() {
        String username = enterAndValidateUsername();
        String email = enterAndValidateEmail();
        String password = enterAndValidatePassword();

        String query = "INSERT INTO users(username, email, password) VALUES('" + username + "', '" + email + "', '" +
                password + "')";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Đăng kí tài khoản " + username + " thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User signIn() {
        // Nếu đăng nhập thành công trả về user
        // Nếu không, trả về null

        String username;
        String password;

        // Check username
        while (true) {
            System.out.print("Nhập username: ");
            username = sc.nextLine();
            if (usernameInList(username)) {
                break;
            }
            System.out.println("Kiểm tra lại username");
        }

        // Check password
        User user = getUserByUsername(username);
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

    public void forgetPassword() {
        System.out.print("Nhập email: ");
        String email = sc.nextLine();
        if (emailInList(email)) {
            String newPassword = enterAndValidatePassword();
            User user = getUserByEmail(email);
            changePassword(user, newPassword);
        } else {
            System.out.println("Chưa tồn tại tài khoản");
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM users";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                User user = new User(id, username, email, password);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public User getUserByUsername(String findUsername) {
        String query = "SELECT * FROM users WHERE username = '" + findUsername + "'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(id, username, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByEmail(String findEmail) {
        String query = "SELECT * FROM users WHERE email = '" + findEmail + "'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(id, username, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeUsername(User user, String newUsername) {
        String query = "UPDATE users SET username = '" + newUsername + "' WHERE id = '" + user.getId() + "'";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            user.setUsername(newUsername);
            System.out.println("Cập nhật thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeEmail(User user, String newEmail) {
        String query = "UPDATE users SET email = '" + newEmail + "' WHERE id = '" + user.getId() + "'";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            user.setEmail(newEmail);
            System.out.println("Cập nhật thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(User user, String newPassword) {
        String query = "UPDATE users SET password = '" + newPassword + "' WHERE id = '" + user.getId() + "'";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            user.setPassword(newPassword);
            System.out.println("Cập nhật thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
