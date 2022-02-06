package util;

import model.MovieList;
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
        return 1 <= point && point <= 10;
    }

    public static boolean validateMovieListNameAvailable(List<MovieList> movieLists, MovieList movieList, String name) {
        for (MovieList m : movieLists) {
            if (!m.equals(movieList) && m.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateMovieListNameAvailable(List<MovieList> movieLists, String name) {
        for (MovieList m : movieLists) {
            if (m.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }
}