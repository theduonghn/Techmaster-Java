import java.util.Arrays;

public class Book {
    private int id;
    private String title;
    private String[] categories;
    private String author;
    private int publishedYear;
    private String publishingCompany;

    public Book(int id, String title, String[] categories, String author, int publishedYear, String publishingCompany) {
        this.id = id;
        this.title = title;
        this.categories = categories;
        this.author = author;
        this.publishedYear = publishedYear;
        this.publishingCompany = publishingCompany;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", categories=" + Arrays.toString(categories) + ", id=" + id
                + ", publishedYear=" + publishedYear + ", publishingCompany=" + publishingCompany + ", title=" + title
                + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

}
