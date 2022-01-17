import util.MyFormat;

import java.time.LocalDate;

public class Transaction {
    private long id;
    private LocalDate date;
    private String description;
    private String receiveAccountNumber;
    private long cashAmount;

    public Transaction(long id, LocalDate date, String description, String receiveAccountNumber, long cashAmount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.receiveAccountNumber = receiveAccountNumber;
        this.cashAmount = cashAmount;
    }

    @Override
    public String toString() {
        return id + " - " + date + " - " + description + " - " + receiveAccountNumber + " - " +
                MyFormat.formatVnd(cashAmount);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceiveAccountNumber() {
        return receiveAccountNumber;
    }

    public void setReceiveAccountNumber(String receiveAccountNumber) {
        this.receiveAccountNumber = receiveAccountNumber;
    }

    public long getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(long cashAmount) {
        this.cashAmount = cashAmount;
    }
}
