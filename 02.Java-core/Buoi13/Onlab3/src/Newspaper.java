import java.time.LocalDate;
import java.util.ArrayList;

public class Newspaper extends Book {
    private LocalDate publishedDate;
    private int quantity;
    private int page;

    public Newspaper(int id, String name, ArrayList<String> categories, String publishingCompany,
                     LocalDate publishedDate, int quantity, int page) {
        super(id, name, categories, publishingCompany);
        this.publishedDate = publishedDate;
        this.quantity = quantity;
        this.page = page;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + publishedDate + " - " + quantity + " - " + page;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
