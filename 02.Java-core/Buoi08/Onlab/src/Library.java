public class Library {
    private String code;
    private String name;
    private String publishingCompany;
    private int publishedYear;
    private int quantity;

    public Library(String code, String name, String publishingCompany, int publishedYear, int quantity) {
        this.code = code;
        this.name = name;
        this.publishingCompany = publishingCompany;
        this.publishedYear = publishedYear;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
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

    @Override
    public String toString() {
        return "code=" + code + ", name=" + name + ", publishedYear=" + publishedYear + ", publishingCompany="
                + publishingCompany + ", quantity=" + quantity;
    }
}
