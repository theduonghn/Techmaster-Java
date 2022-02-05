package service;

import model.MovieList;
import model.User;
import model.UserRole;
import util.UserUtil;
import util.Util;
import util.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    public List<User> initUsers() {
        List<User> users = new ArrayList<>();

        User admin = new User("admin@gmail.com", "123", UserRole.ADMIN);
        users.add(admin);

        User user1 = new User("user1@gmail.com", "123", UserRole.USER);
        users.add(user1);

        User user2 = new User("user2@gmail.com", "123", UserRole.USER);
        users.add(user2);

        return users;
    }

    public User getUserById(List<User> users, UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByEmail(List<User> users, String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User login(List<User> users) {
        System.out.print("Nhập email: ");
        String email = Util.sc.nextLine();
        User user = getUserByEmail(users, email);
        if (user == null) {
            System.out.println("Email không tồn tại");
            return null;
        }
        System.out.print("Nhập mật khẩu: ");
        String password = Util.sc.nextLine();
        if (user.getPassword().equals(password)) {
            System.out.println("Đăng nhập thành công");
            return user;
        } else {
            System.out.println("Sai mật khẩu");
            return null;
        }
    }

    public void register(List<User> users) {
        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = Util.sc.nextLine();
            if (!Validate.validateEmailPattern(email)) {
                System.out.println("Email không hợp lệ");
            } else if (!Validate.validateEmailAvailable(users, email)) {
                System.out.println("Email đã được sử dụng");
            } else {
                System.out.println("Đăng kí thành công");
                break;
            }
        }
        System.out.print("Nhập mật khẩu: ");
        String password = Util.sc.nextLine();
        User user = new User(email, password, UserRole.USER);
        users.add(user);
    }

    public void updatePassword(User user, String password) {
        user.setPassword(password);
    }

    public void addMovieList(User user, MovieList movieList) {
        user.addMovieList(movieList);
    }

    public void removeMovieList(User user, MovieList movieList) {
        user.removeMovieList(movieList);
    }
}
