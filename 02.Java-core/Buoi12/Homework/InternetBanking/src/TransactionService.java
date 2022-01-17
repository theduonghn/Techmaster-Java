import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionService {
    Scanner sc = new Scanner(System.in);

    public void transact(BankAccount account) {
        try {
            System.out.print("Nhập ngân hàng thụ hưởng: ");
            String receiveBank = sc.nextLine();

            System.out.print("Nhập STK thụ hưởng: ");
            String receiveAccountNumber = sc.nextLine();
            TransactionValidator.validateAccountNumber(receiveAccountNumber);

            System.out.print("Nhập số tiền: ");
            long cashAmount = Long.parseLong(sc.nextLine());
            TransactionValidator.validateCashAmount(account, cashAmount);

            System.out.print("Nhập mô tả: ");
            String description = sc.nextLine();

            // Decrease the cash amount in balance
            account.setBalance(account.getBalance() - cashAmount);

            // Create transaction
            account.incrementNumTransaction();
            long transactionId = account.getNumTransaction();
            Transaction transaction =
                    new Transaction(transactionId, LocalDate.now(), description, receiveAccountNumber, cashAmount);
            account.getTransactions().add(transaction);

            // Thông báo
            System.out.println("Giao dịch thành công");
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
            System.out.println("Giao dịch thất bại");
        }
    }

    public void showTransactions(BankAccount account) {
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }
}
