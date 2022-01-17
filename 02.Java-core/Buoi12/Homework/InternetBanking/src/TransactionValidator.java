import util.MyFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionValidator {
    static final long MINIMUM_CASH_AMOUNT = 50000L;
    static final Pattern VALID_ACCOUNT_NUMBER = Pattern.compile("^[0-9]{8,16}$");

    public static boolean validAccountNumber(String accountNumber) {
        Matcher matcher = VALID_ACCOUNT_NUMBER.matcher(accountNumber);
        return matcher.find();
    }

    public static void validateAccountNumber(String accountNumber) throws TransactionException {
        if (!validAccountNumber(accountNumber)) {
            throw new TransactionException("Số tài khoản thụ hưởng không hợp lệ");
        }
    }

    public static void validateCashAmount(BankAccount account, long cashAmount) throws TransactionException {
        if (cashAmount < MINIMUM_CASH_AMOUNT) {
            throw new TransactionException("Số tiền chuyển phải tối thiểu là " + MyFormat.formatVnd(MINIMUM_CASH_AMOUNT));
        }
        if (account.getBalance() - cashAmount < MINIMUM_CASH_AMOUNT) {
            throw new TransactionException(
                    "Số dư sau khi chuyển tiền phải tối thiểu là " + MyFormat.formatVnd(MINIMUM_CASH_AMOUNT));
        }
    }
}
