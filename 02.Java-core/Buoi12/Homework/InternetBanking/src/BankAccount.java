import java.util.ArrayList;

public class BankAccount {
    private String phoneNumber;
    private String password;
    private long balance;
    private long numTransaction;
    private ArrayList<Transaction> transactions;

    public BankAccount(String phoneNumber, String password, long balance) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.balance = balance;
        this.numTransaction = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "BankAccount{" + "phoneNumber='" + phoneNumber + '\'' + ", password='" + password + '\'' + ", balance=" +
                balance + ", numTransaction=" + numTransaction + '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getNumTransaction() {
        return numTransaction;
    }

    public void incrementNumTransaction() {
        this.numTransaction++;
    }

    public void setNumTransaction(long numTransaction) {
        this.numTransaction = numTransaction;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
