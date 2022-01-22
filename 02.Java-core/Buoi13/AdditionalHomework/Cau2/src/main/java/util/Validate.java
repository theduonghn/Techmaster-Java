package util;

import model.Customer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean validateCustomerIdPattern(ArrayList<Customer> customers, String id) {
        final Pattern VALID_CUSTOMER_ID_REGEX = Pattern.compile("^KH[0-9]{7}$");
        Matcher matcher = VALID_CUSTOMER_ID_REGEX.matcher(id);
        return matcher.find();
    }

    public static boolean validateCustomerIdAvailable(ArrayList<Customer> customers, String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validatePhone(String phone) {
        final Pattern VALID_PHONE_REGEX = Pattern.compile("^[0-9]{10,11}$");
        Matcher matcher = VALID_PHONE_REGEX.matcher(phone);
        return matcher.find();
    }

    public static boolean validateEmail(String email) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
}
