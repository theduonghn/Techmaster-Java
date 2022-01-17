import util.MyFormat;

import java.util.ArrayList;

public class Product {
    private String id;
    private String name;
    private String description;
    private long price;
    private int quantity;
    private int soldQuantity;
    private String company;
    private ArrayList<Category> categories;

    public Product(String id, String name, String description, long price, int quantity, int soldQuantity,
                   String company, ArrayList<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
        this.company = company;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", price=" + MyFormat.formatVnd(price) + ", quantity=" +
                quantity + ", soldQuantity=" + soldQuantity + ", company='" + company + '\'' + ", categories=" +
                categories + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
