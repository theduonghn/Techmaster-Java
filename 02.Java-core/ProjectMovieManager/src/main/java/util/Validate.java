package util;

import model.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean validateEmailPattern(String email) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean validateEmailAvailable(List<User> users, String email) {
        return !UserUtil.emailExists(users, email);
    }

    public static boolean validateRatingPoint(int point) {
        if (0 <= point && point <= 10) {
            return true;
        } else {
            return false;
        }
    }
}