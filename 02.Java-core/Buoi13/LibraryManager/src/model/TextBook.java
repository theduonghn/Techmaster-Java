package model;

import java.util.ArrayList;

public class TextBook extends Book {
    private int publishedYear;
    private int quantity;
    private int page;
    private String author;

    public TextBook(int id, String name, ArrayList<String> categories, String publishingCompany, int publishedYear,
                    int quantity, int page, String author) {
        super(id, name, categories, publishingCompany);
        this.publishedYear = publishedYear;
        this.quantity = quantity;
        this.page = page;
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + publishedYear + " - " + quantity + " - " + page + " - " + author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
