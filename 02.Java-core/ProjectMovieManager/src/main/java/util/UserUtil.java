package util;

import model.User;

import java.util.List;

public class UserUtil {
    public static boolean emailExists(List<User> users, String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }
}
