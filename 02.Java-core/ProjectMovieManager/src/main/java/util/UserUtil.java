package util;

import model.User;

import java.util.List;

public class UserUtil {
    public static boolean emailExists(List<User> users, String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
